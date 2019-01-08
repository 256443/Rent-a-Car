package com.antoszek.services;

import com.antoszek.model.entityClass.Car;
import com.antoszek.repository.CarRepository;

import java.util.Optional;

import jdk.management.resource.ResourceRequestDeniedException;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    public Car save(Car car) {
        Car savedCar = carRepository.save(car);
        return savedCar;
    }

    public List<Car> findAll() {
        Iterable<Car> carsIterable = carRepository.findAll();
        List<Car> cars = Lists.newArrayList(carsIterable);
        return cars;
    }

    public Car findById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return car.get();
        }
        return null;
    }

    public Car update(Car car) {
        if (carRepository.existsById(car.getId())) {
            return carRepository.save(car);
        } else {
            return null;
        }
    }
//    public Car update(Car car) {
//        Car updatedCar = carRepository.save(car);
//        return updatedCar;
//    }

    public String deleteCar(Long id) {
        carRepository.deleteById(id);
        return "Pomyslnie usunieto samochłd z bazy";

    }
}
