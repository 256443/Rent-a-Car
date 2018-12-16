package com.antoszek.model.entityClass;

import com.antoszek.model.enumClass.CarClass;
import com.antoszek.model.enumClass.TypeOfCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Immutable;


import javax.persistence.*;

import static javax.persistence.EnumType.STRING;


@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Car {

    @Id
    @GeneratedValue
    private Long id;
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

    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "car")
    @JoinColumn(name = "engine_id", nullable = false)
    private Engine engine;

    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "car")
    @JoinColumn(name = "interiorFeatures_id", nullable = false)
    private InteriorFeatures interiorFeatures;

    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "car")
    @JoinColumn(name = "parkingSensor_id", nullable = false)
    private ParkingSensor parkingSensor;

    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "car")
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public InteriorFeatures getInteriorFeatures() {
        return interiorFeatures;
    }

    public void setInteriorFeatures(InteriorFeatures interiorFeatures) {
        this.interiorFeatures = interiorFeatures;
    }

    public ParkingSensor getParkingSensor() {
        return parkingSensor;
    }

    public void setParkingSensor(ParkingSensor parkingSensor) {
        this.parkingSensor = parkingSensor;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
}
