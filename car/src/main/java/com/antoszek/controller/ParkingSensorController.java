package com.antoszek.controller;


import com.antoszek.model.entityClass.ParkingSensor;
import com.antoszek.services.ParkingSensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/car/parking_sensor")
public class ParkingSensorController {
    private static final Logger log = LoggerFactory.getLogger(ParkingSensorController.class);
    private final ParkingSensorService parkingSensorService;

    @Autowired
    public ParkingSensorController(ParkingSensorService parkingSensorService) {
        this.parkingSensorService = parkingSensorService;
    }

    @RequestMapping("/app/car/parking_sensor/all")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ParkingSensor> getParkingSensorList(){
        List<ParkingSensor> parkingSensors =parkingSensorService.findAll();
        log.info("Retrive objects {}", parkingSensors);
        return parkingSensors;
    }
}
