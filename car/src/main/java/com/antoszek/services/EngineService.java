package com.antoszek.services;

import com.antoszek.model.entityClass.Engine;
import com.antoszek.repository.EngineRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineService {
    private final EngineRepository engineRepository;

    @Autowired
    public EngineService(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    public Engine save(Engine engine){
        Engine saveEngine = engineRepository.save(engine);
        return saveEngine;
    }

    public List<Engine> findAll(){
        Iterable<Engine> engineIterable = engineRepository.findAll();
        List<Engine> engines = Lists.newArrayList(engineIterable);
        return engines;
    }
}
