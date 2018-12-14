package com.antoszek.controller;

import com.antoszek.model.entityClass.InteriorFeatures;
import com.antoszek.services.InteriorFeaturesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/app/car/interiorFeatures")
public class InteriorFeaturesController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(InteriorFeaturesController.class);

    private final InteriorFeaturesService interiorFeaturesService;

    @Autowired
    public InteriorFeaturesController(InteriorFeaturesService interiorFeaturesService) {

        this.interiorFeaturesService = interiorFeaturesService;
    }

    @RequestMapping("/app/car/all_interior_features")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<InteriorFeatures> getInteriorFeatures(){
        List<InteriorFeatures> interiorFeatures = interiorFeaturesService.findAll();
        log.info("Retrive objects {}", interiorFeatures);
        return interiorFeatures;
    }
}
