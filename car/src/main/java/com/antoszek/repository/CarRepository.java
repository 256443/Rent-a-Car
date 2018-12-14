package com.antoszek.repository;

import com.antoszek.model.entityClass.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
