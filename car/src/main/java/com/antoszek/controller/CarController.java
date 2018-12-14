package com.antoszek.controller;

import com.antoszek.model.ModelDTO.EngineDTO;
import com.antoszek.model.entityClass.Car;
import com.antoszek.model.entityClass.Engine;
import com.antoszek.services.CarService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/car")
public class CarController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(CarController.class);
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {

        this.carService = carService;
    }

    @RequestMapping("/all_car")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Car> getCars(){
        List<Car> cars = carService.findAll();
        log.info("Retrive objects {}", cars);
        return cars;
    }

    @RequestMapping("/add_car")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Car save(@RequestBody Car car){
        Car savedCar = carService.save(car);
        log.info("Add new Car[]", savedCar.getMake() +",  " + savedCar.getModel() );
        return savedCar;
    }

}
