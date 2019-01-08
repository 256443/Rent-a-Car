package com.antoszek.model;

import com.antoszek.model.enumClass.CarClass;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;
    private Long client_id;
    private Long car_id;
    private double value;
    private Long rental_id;

    public Invoice() {
    }

    public Invoice(Long client_id, Long car_id, double value) {
        this.client_id = client_id;
        this.car_id = car_id;
        this.value = value;
    }

    public Long getRental_id() {
        return rental_id;
    }

    public void setRental_id(Long rental_id) {
        this.rental_id = rental_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }



    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
