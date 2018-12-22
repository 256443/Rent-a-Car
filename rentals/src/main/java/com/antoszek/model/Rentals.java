package com.antoszek.model;

import com.antoszek.model.entityClass.Car;
import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
public class Rentals {

    @Id
    @GeneratedValue
    private Long id;
//    @Column(name = "car")
//    private Car car;
//    @Column(name = "client")
//    private Client client;
    private Long client_id;
    private Long car_id;

    public Rentals() {
    }

    public Rentals(Long client_id, Long car_id) {
        this.client_id = client_id;
        this.car_id = car_id;
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
}
