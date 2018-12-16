package com.antoszek.controller;

import com.antoszek.model.ModelDTO.InteriorFeaturesDTO;
import com.antoszek.model.entityClass.Car;
import com.antoszek.model.entityClass.InteriorFeatures;
import com.antoszek.services.CarService;
import com.antoszek.services.InteriorFeaturesService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/car/interior_features")
public class InteriorFeaturesController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(InteriorFeaturesController.class);

    private final InteriorFeaturesService interiorFeaturesService;
    private final CarService carService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public InteriorFeaturesController(InteriorFeaturesService interiorFeaturesService, CarService carService) {

        this.interiorFeaturesService = interiorFeaturesService;
        this.carService = carService;
    }

    @RequestMapping("/all_interior_features")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<InteriorFeatures> getInteriorFeatures(){
        List<InteriorFeatures> interiorFeatures = interiorFeaturesService.findAll();
        log.info("Retrive objects {}", interiorFeatures);
        return interiorFeatures;
    }

    @RequestMapping(value = "/add_interior_features_to_car",method = RequestMethod.POST)
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public String saveInteriorFeaturesToCar(@RequestBody InteriorFeaturesDTO interiorFeaturesDTO){
        InteriorFeatures savedInteriorFeatures =  modelMapper.map(interiorFeaturesDTO,InteriorFeatures.class);
        Car car = carService.findById(interiorFeaturesDTO.getCar_id());
        savedInteriorFeatures.setCar(car);
        interiorFeaturesService.save(savedInteriorFeatures);
        return "Added interior features to car ID:  " + savedInteriorFeatures.getCar().getId();
    }
}




//        InteriorFeatures savedInteriorFeatures = new InteriorFeatures();

//        savedInteriorFeatures.setSkiRack(interiorFeaturesDTO.isSkiRack());
//        savedInteriorFeatures.setBluetooth(interiorFeaturesDTO.isBluetooth());
//        savedInteriorFeatures.setCentralLocking(interiorFeaturesDTO.isCentralLocking());
//        savedInteriorFeatures.setRainSensor(interiorFeaturesDTO.isRainSensor());
//        savedInteriorFeatures.setElectricalWindows(interiorFeaturesDTO.isElectricalWindows());
//        savedInteriorFeatures.setElectricalMirror(interiorFeaturesDTO.isElectricalMirror());
//        savedInteriorFeatures.setElectricSeatAdjustment(interiorFeaturesDTO.isElectricSeatAdjustment());
//        savedInteriorFeatures.setMP3interface(interiorFeaturesDTO.isMP3interface());
//        savedInteriorFeatures.setIsofixSystem(interiorFeaturesDTO.isIsofixSystem());
//        savedInteriorFeatures.setOn_boardComputer(interiorFeaturesDTO.isOn_boardComputer());
//        savedInteriorFeatures.setCDPlayer(interiorFeaturesDTO.isCDPlayer());
//        savedInteriorFeatures.setHeatedSeats(interiorFeaturesDTO.isHeatedSeats());
//        savedInteriorFeatures.setRadioFM(interiorFeaturesDTO.isRadioFM());
//        savedInteriorFeatures.setNavigationSystem(interiorFeaturesDTO.isNavigationSystem());
//        savedInteriorFeatures.setStartStopSystem(interiorFeaturesDTO.isStartStopSystem());
//        savedInteriorFeatures.setSunroof(interiorFeaturesDTO.isSunroof());
//        savedInteriorFeatures.setCruiseControl(interiorFeaturesDTO.isCruiseControl());
//        savedInteriorFeatures.setVentilatedSeats(interiorFeaturesDTO.isVentilatedSeats());
//        savedInteriorFeatures.setMultifunctionSteeringWheel(interiorFeaturesDTO.isMultifunctionSteeringWheel());
//        savedInteriorFeatures.setPowerSteering(interiorFeaturesDTO.isPowerSteering());
//        savedInteriorFeatures.setTouchScreen(interiorFeaturesDTO.isTouchScreen());
//        savedInteriorFeatures.setLoudspeekerSysetm(interiorFeaturesDTO.isLoudspeekerSysetm());
//        savedInteriorFeatures.setAirConditioning(interiorFeaturesDTO.getAirConditioning());