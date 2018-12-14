package com.antoszek.repository;

import com.antoszek.model.entityClass.Engine;
import org.springframework.data.repository.CrudRepository;

public interface EngineRepository extends CrudRepository<Engine, Long> {
}
