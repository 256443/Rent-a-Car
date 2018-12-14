package com.antoszek.model.entityClass;

import com.antoszek.model.entityClass.Car;
import com.antoszek.model.enumClass.TypeOfDrive;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Security {
    @Id
    @GeneratedValue
    private Long id;
    private boolean ABSSystem;
    private boolean blindSpotAssist; //asysten martwego punktu;
    private boolean lightSensor;
    private boolean emergencyBrakeAssist; //asystent hamowania awaryjnego
    private boolean immobilizer;
    private boolean tractionControl;
    @Enumerated
    private TypeOfDrive typeOfDrive;
    private boolean lightXenon;
    private boolean lightLED;
    private boolean LaneDepartureWarningSystem; //system ostrzegania o zmianie pasa ruchu.
    private boolean daytimeLight; //światła do jazdy dziennej
    private boolean ESPSystem;
    private int namberOfAirbag;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isABSSystem() {
        return ABSSystem;
    }

    public void setABSSystem(boolean ABSSystem) {
        this.ABSSystem = ABSSystem;
    }

    public boolean isBlindSpotAssist() {
        return blindSpotAssist;
    }

    public void setBlindSpotAssist(boolean blindSpotAssist) {
        this.blindSpotAssist = blindSpotAssist;
    }

    public boolean isLightSensor() {
        return lightSensor;
    }

    public void setLightSensor(boolean lightSensor) {
        this.lightSensor = lightSensor;
    }

    public boolean isEmergencyBrakeAssist() {
        return emergencyBrakeAssist;
    }

    public void setEmergencyBrakeAssist(boolean emergencyBrakeAssist) {
        this.emergencyBrakeAssist = emergencyBrakeAssist;
    }

    public boolean isImmobilizer() {
        return immobilizer;
    }

    public void setImmobilizer(boolean immobilizer) {
        this.immobilizer = immobilizer;
    }

    public boolean isTractionControl() {
        return tractionControl;
    }

    public void setTractionControl(boolean tractionControl) {
        this.tractionControl = tractionControl;
    }

    public TypeOfDrive getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(TypeOfDrive typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public boolean isLightXenon() {
        return lightXenon;
    }

    public void setLightXenon(boolean lightXenon) {
        this.lightXenon = lightXenon;
    }

    public boolean isLightLED() {
        return lightLED;
    }

    public void setLightLED(boolean lightLED) {
        this.lightLED = lightLED;
    }

    public boolean isLaneDepartureWarningSystem() {
        return LaneDepartureWarningSystem;
    }

    public void setLaneDepartureWarningSystem(boolean laneDepartureWarningSystem) {
        LaneDepartureWarningSystem = laneDepartureWarningSystem;
    }

    public boolean isDaytimeLight() {
        return daytimeLight;
    }

    public void setDaytimeLight(boolean daytimeLight) {
        this.daytimeLight = daytimeLight;
    }

    public boolean isESPSystem() {
        return ESPSystem;
    }

    public void setESPSystem(boolean ESPSystem) {
        this.ESPSystem = ESPSystem;
    }

    public int getNamberOfAirbag() {
        return namberOfAirbag;
    }

    public void setNamberOfAirbag(int namberOfAirbag) {
        this.namberOfAirbag = namberOfAirbag;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
