package com.antoszek.repository;

import com.antoszek.model.Rentals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentalRepository extends CrudRepository<Rentals,Long> {

    @Query(value = "SELECT p FROM Rentals p WHERE p.client_id=?1")
    List<Rentals> getRentalsByClient_id(Long id);

    @Query(value = "SELECT p FROM Rentals p WHERE p.car_id=?1")
    List<Rentals> getRentalsByCar_id(Long id);

}
