package com.antoszek.service;

import com.antoszek.model.Client;
import com.antoszek.model.Rentals;
import com.antoszek.model.entityClass.Car;
import com.antoszek.repository.RentalRepository;
import com.antoszek.services.CarService;
import com.antoszek.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Rentals savedrental = rentalRepository.save(rentals);
            return savedrental;
        }

    }
}



//        try {
//            Car car = carService.findById(rentals.getCar_id());
//        } catch (NullPointerException e) {
//            System.out.println("Nie znaleiono samochodu o podnym id");
//        }
//        try {
//            Client client = clientService.findById(rentals.getClient_id());
//        }catch (NullPointerException e){
//            System.out.println("Nie znaleziono klienta o podanym id");
//        }