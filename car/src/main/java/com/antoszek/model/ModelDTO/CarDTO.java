package com.antoszek.model.ModelDTO;

import com.antoszek.model.enumClass.CarClass;
import com.antoszek.model.enumClass.TypeOfCar;

import javax.persistence.Enumerated;

import static javax.persistence.EnumType.STRING;

public class CarDTO {
    private String make;
    private String model;
    private int yearOfProduction;
    private boolean availability;
    @Enumerated(STRING)
    private CarClass carClass;
    @Enumerated(STRING)
    private TypeOfCar typeOfCar;
    private int numberOfSeats;
    private String numberOfDors;
    private String color;
    private Long client_id;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getNumberOfDors() {
        return numberOfDors;
    }

    public void setNumberOfDors(String numberOfDors) {
        this.numberOfDors = numberOfDors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
