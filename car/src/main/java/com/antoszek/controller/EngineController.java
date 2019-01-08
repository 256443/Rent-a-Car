package com.antoszek.controller;


import com.antoszek.model.ModelDTO.EngineDTO;
import com.antoszek.model.entityClass.Car;
import com.antoszek.model.entityClass.Engine;
import com.antoszek.services.CarService;
import com.antoszek.services.EngineService;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/car/engine")
public class EngineController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(EngineController.class);
    private final EngineService engineService;
    private final CarService carService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public EngineController(EngineService engineService, CarService carService) {
        this.engineService = engineService;
        this.carService = carService;
    }

    @RequestMapping("/all_engine")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Engine> getEngines(){
        List<Engine> engines = engineService.findAll();
        log.info("Retrive objects {}", engines);
        return engines;
    }
    @RequestMapping(value = "/add_engine_to_car", method = RequestMethod.POST)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Engine saveEngineToCar(@RequestBody EngineDTO engineDTO){
        Engine savedEngine = modelMapper.map(engineDTO, Engine.class);
        Car car = carService.findById(engineDTO.getCar_id());
        savedEngine.setCar(car);
        engineService.save(savedEngine);
        return savedEngine;
    }
    @RequestMapping("/edit/{id}")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Engine update(@PathVariable Long id, @RequestBody EngineDTO engineDTO) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        Engine updateEngine = engineService.findById(id);
        modelMapper.map(engineDTO,updateEngine);
        engineService.save(updateEngine);
        log.info("Update car Car[]", updateEngine.getPowerInKW() + ",  " + updateEngine.getPowerInPS());
        return updateEngine;
    }

    @RequestMapping("/edit")
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Engine update(@RequestBody Engine engine) {
        Engine updateEngine= engineService.update(engine);
        log.info("Updated Car {}", updateEngine);
        return updateEngine;
    }

    @RequestMapping("/find_byId/{id}")
    @GetMapping(consumes = APPLICATION_JSON_VALUE)
    public Engine getEngineById(@PathVariable Long id) {
        return engineService.findById(id);
    }

    @DeleteMapping("/delete_engine/{id}")
    public String deleteEngine(@PathVariable Long id) {
        engineService.deleteEngine(id);
        return "Pomyślnie usunięto silnik z samochodu";
    }
}

