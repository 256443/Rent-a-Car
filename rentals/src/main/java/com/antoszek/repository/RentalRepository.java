package com.antoszek.repository;

import com.antoszek.model.Rentals;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rentals,Long> {
}
