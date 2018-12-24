package com.antoszek.services;

import com.antoszek.model.entityClass.Engine;
import com.antoszek.repository.EngineRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Engine findById(Long id) {
        Optional<Engine> engine = engineRepository.findById(id);
        if (engine.isPresent()) {
            return engine.get();
        }
        return null;
    }

    public Engine update(Engine engine) {
        if(engineRepository.existsById(engine.getId())){
            return engineRepository.save(engine);
        }
        else{
            return null;      }
    }
    public String deleteEngine(Long id){
        engineRepository.deleteById(id);
        return "Pomyslnie usunieto silnik z bazy";

    }
}
