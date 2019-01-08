package com.antoszek.controller;

import com.antoszek.model.ModelDTO.CarDTO;
import com.antoszek.model.entityClass.Car;
import com.antoszek.repository.CarRepository;
import com.antoszek.services.CarService;

import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/car")
public class CarController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(CarController.class);
    private final CarService carService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CarController(CarService carService) {

        this.carService = carService;

    }

    @RequestMapping("/all_car")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Car> getCars() {
        List<Car> cars = carService.findAll();
        log.info("Retrive objects {}", cars);
        return cars;
    }

    @RequestMapping("/add_car")
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Car save(@RequestBody Car car) {
        Car savedCar = carService.save(car);
        log.info("Add new Car[]", savedCar.getMake() + ",  " + savedCar.getModel());
        return savedCar;
    }

        @RequestMapping("/edit/{id}")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Car update(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Car updateCar = carService.findById(id);
        modelMapper.map(carDTO, updateCar);
        carService.save(updateCar);
        log.info("Update car Car[]", updateCar.getMake() + ",  " + updateCar.getModel());
        return updateCar;

    }

    @RequestMapping("/find_byId/{id}")
    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    public Car getCarById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @DeleteMapping("/delete_car/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "Pomyślnie usunięto samochod";
    }

}
