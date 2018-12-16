package com.antoszek.model.ModelDTO;

import com.antoszek.model.enumClass.FuelType;
import com.antoszek.model.enumClass.TransmissionType;
import com.antoszek.model.enumClass.TypeOfDrive;

import javax.persistence.Enumerated;

import static javax.persistence.EnumType.STRING;

public class EngineDTO {
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
    private Long car_id;

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

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
}
