package com.antoszek.model.entityClass;

import com.antoszek.model.entityClass.Car;
import com.antoszek.model.enumClass.FuelType;
import com.antoszek.model.enumClass.TransmissionType;
import com.antoszek.model.enumClass.TypeOfDrive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Engine {
    @Id
    @GeneratedValue
    private Long id;

    private int powerInPS;
    private int powerInKW;
    @Enumerated(STRING)
    private FuelType fuelEngine;
    @Enumerated(STRING)
    private TransmissionType transmissionType;
    @Enumerated(STRING)
    private TypeOfDrive typeOfDrive;
    private int cubicCapacity;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPowerInPS() {
        return powerInPS;
    }

    public void setPowerInPS(int powerInPS) {
        this.powerInPS = powerInPS;
    }

    public int getPowerInKW() {
        return powerInKW;
    }

    public void setPowerInKW(int powerInKW) {
        this.powerInKW = powerInKW;
    }

    public FuelType getFuelEngine() {
        return fuelEngine;
    }

    public void setFuelEngine(FuelType fuelEngine) {
        this.fuelEngine = fuelEngine;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public TypeOfDrive getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(TypeOfDrive typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
