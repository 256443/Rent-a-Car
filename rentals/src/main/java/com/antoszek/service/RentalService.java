package com.antoszek.service;

import com.antoszek.model.Client;
import com.antoszek.model.Rentals;
import com.antoszek.model.entityClass.Car;
import com.antoszek.repository.RentalRepository;
import com.antoszek.services.CarService;
import com.antoszek.services.ClientService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final ClientService clientService;
    private final CarService carService;

    @Autowired
    public RentalService(RentalRepository rentalRepository, ClientService clientService, CarService carService) {
        this.rentalRepository = rentalRepository;
        this.clientService = clientService;
        this.carService = carService;
    }




    public Rentals save(Rentals rentals) {
        Car car = carService.findById(rentals.getCar_id());
        Client client = clientService.findById(rentals.getClient_id());
        if(car == null || client == null){
            System.out.println("Nie znaleziono jednego z podanych id");
            return null;
        }
        if(car.isAvailability()==false){
            System.out.println("Auto w tej chiwli jest nie dostepne");
            return null;
        }
        else {
            Rentals savedRental = rentalRepository.save(rentals);
            car.setAvailability(false);
            carService.update(car);
            return savedRental;
        }
    }
    public Rentals saveForUpdate(Rentals rentals) {
        Rentals updatedRentals = rentalRepository.save(rentals);
        return updatedRentals;
    }
    public List<Rentals> getRentalsByClientId(Long id) {
        return rentalRepository.getRentalsByClient_id(id);
    }

    public List<Rentals> getRentalsByCarId(Long id) {
        return rentalRepository.getRentalsByCar_id(id);
    }
    public List<Rentals> findAll(){
        Iterable<Rentals> rentalsIterable = rentalRepository.findAll();
        List<Rentals> rental = Lists.newArrayList(rentalsIterable);
        return rental;
    }
    public Rentals findById(Long id) {
        Optional<Rentals> rentals = rentalRepository.findById(id);
        if (rentals.isPresent()) {
            return rentals.get();
        }
        return null;
    }

    public String endOffRental(Long id){
        Rentals r = findById(id);
        Car car = carService.findById(r.getCar_id());
        car.setAvailability(true);
        carService.update(car);
        rentalRepository.deleteById(id);
        return "Pomyslnie zwrócono wypozyczony samochód";
    }


}
