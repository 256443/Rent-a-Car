package com.antoszek.controller;


import com.antoszek.model.ModelDTO.ParkingSensorDTO;
import com.antoszek.model.entityClass.Car;
import com.antoszek.model.entityClass.ParkingSensor;
import com.antoszek.services.CarService;
import com.antoszek.services.ParkingSensorService;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/car/parking_sensor")
public class ParkingSensorController {
    private static final Logger log = LoggerFactory.getLogger(ParkingSensorController.class);
    private final ParkingSensorService parkingSensorService;
    private final CarService carService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ParkingSensorController(ParkingSensorService parkingSensorService, CarService carService) {
        this.parkingSensorService = parkingSensorService;
        this.carService = carService;
    }

    @RequestMapping("/all_parking_sensor")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ParkingSensor> getParkingSensorList(){
        List<ParkingSensor> parkingSensors =parkingSensorService.findAll();
        log.info("Retrive objects {}", parkingSensors);
        return parkingSensors;
    }

    @RequestMapping(value = "/add_parking_sensor", method = RequestMethod.POST)
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public String saveParkingSensor(@RequestBody ParkingSensorDTO parkingSensorDTO){
        ParkingSensor savedParkingSensor = modelMapper.map(parkingSensorDTO,ParkingSensor.class);
        Car car = carService.findById(parkingSensorDTO.getCar_id());
        savedParkingSensor.setCar(car);
        parkingSensorService.save(savedParkingSensor);
        return "Added parking sensor to car ID: " + savedParkingSensor.getCar().getId();
    }
    @RequestMapping("/edit/{id}")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public ParkingSensor update(@PathVariable Long id, @RequestBody ParkingSensorDTO parkingSensorDTO) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        ParkingSensor updateParkingSensor = parkingSensorService.findById(id);
        modelMapper.map(parkingSensorDTO, updateParkingSensor);
        parkingSensorService.save(updateParkingSensor);
        log.info("Update car Car[]", updateParkingSensor.getId());
        return updateParkingSensor;

    }

    @RequestMapping("/find_byId/{id}")
    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    public ParkingSensor getEngineById(@PathVariable Long id) {
        return parkingSensorService.findById(id);
    }

    @DeleteMapping("/delete_parking_sensor/{id}")
    public String deleteParkingSensor(@PathVariable Long id) {
        parkingSensorService.deleteParkingSensor(id);
        return "Pomyślnie usunięto czujniki parkowania  z samochodu";
    }
}
