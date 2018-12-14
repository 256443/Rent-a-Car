package com.antoszek.services;

import com.antoszek.model.entityClass.ParkingSensor;
import com.antoszek.repository.ParkingSensorRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSensorService {

    private final ParkingSensorRepository parkingSensorRepository;

    @Autowired
    public ParkingSensorService(ParkingSensorRepository parkingSensorRepository) {
        this.parkingSensorRepository = parkingSensorRepository;
    }

    public ParkingSensor save(ParkingSensor parkingSensor){
        ParkingSensor savedParkingSensor = parkingSensorRepository.save(parkingSensor);
        return savedParkingSensor;
    }
    public List<ParkingSensor> findAll() {
        Iterable<ParkingSensor> parkingSensorIterable = parkingSensorRepository.findAll();
        List<ParkingSensor> parkingSensors =Lists.newArrayList(parkingSensorIterable);
        return parkingSensors;
    }
}

