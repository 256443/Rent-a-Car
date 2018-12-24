package com.antoszek.model.entityClass;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ParkingSensor {

    @Id
    @GeneratedValue
    private Long id;
    private boolean parkingSensorFront;
    private boolean parkingSensorBack;
    private boolean parkingCamera;
    private boolean automaticParkingSystem;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isParkingSensorFront() {
        return parkingSensorFront;
    }

    public void setParkingSensorFront(boolean parkingSensorFront) {
        this.parkingSensorFront = parkingSensorFront;
    }

    public boolean isParkingSensorBack() {
        return parkingSensorBack;
    }

    public void setParkingSensorBack(boolean parkingSensorBack) {
        this.parkingSensorBack = parkingSensorBack;
    }

    public boolean isParkingCamera() {
        return parkingCamera;
    }

    public void setParkingCamera(boolean parkingCamera) {
        this.parkingCamera = parkingCamera;
    }

    public boolean isAutomaticParkingSystem() {
        return automaticParkingSystem;
    }

    public void setAutomaticParkingSystem(boolean automaticParkingSystem) {
        this.automaticParkingSystem = automaticParkingSystem;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
