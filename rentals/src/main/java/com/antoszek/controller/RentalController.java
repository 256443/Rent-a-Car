package com.antoszek.controller;

import com.antoszek.model.Rentals;
import com.antoszek.model.entityClass.Car;
import com.antoszek.service.RentalService;
import com.antoszek.services.CarService;
import com.antoszek.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/rental")
public class RentalController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(CarController.class);
    private final RentalService rentalService;
    private final CarService carService;
    private final ClientService clientService;
    @Autowired
    public RentalController(RentalService rentalService, CarService carService, ClientService clientService) {
        this.rentalService = rentalService;
        this.carService = carService;
        this.clientService = clientService;
    }

    @RequestMapping("/save_rental")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Rentals save(@RequestBody Rentals rentals){
        Rentals rentalsSaved = rentalService.save(rentals);
        log.info("Add new Rental[]", "Car ID: ",rentalsSaved.getCar_id(), "Client ID: ", rentalsSaved.getClient_id());
        return rentalsSaved;
    }
    @RequestMapping("/user_rental")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Car> getCarsForClientId(){
        List<Car> cars = carService.findAll();
        log.info("Retrive objects {}", cars);
        return cars;
    }

}
