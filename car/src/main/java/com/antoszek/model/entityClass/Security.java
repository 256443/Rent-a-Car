package com.antoszek.model.entityClass;

import com.antoszek.model.entityClass.Car;
import com.antoszek.model.enumClass.TypeOfDrive;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private boolean absSystem;
    private boolean blindSpotAssist; //asysten martwego punktu;
    private boolean lightSensor;
    private boolean emergencyBrakeAssist; //asystent hamowania awaryjnego
    private boolean immobilizer;
    private boolean tractionControl;
    private boolean lightXenon;
    private boolean lightLED;
    private boolean laneDepartureWarningSystem; //system ostrzegania o zmianie pasa ruchu.
    private boolean daytimeLight; //światła do jazdy dziennej
    private boolean espSystem;
    private int numberOfAirbag;

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

    public boolean isAbsSystem() {
        return absSystem;
    }

    public void setAbsSystem(boolean absSystem) {
        this.absSystem = absSystem;
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
        return laneDepartureWarningSystem;
    }

    public void setLaneDepartureWarningSystem(boolean laneDepartureWarningSystem) {
        this.laneDepartureWarningSystem = laneDepartureWarningSystem;
    }

    public boolean isDaytimeLight() {
        return daytimeLight;
    }

    public void setDaytimeLight(boolean daytimeLight) {
        this.daytimeLight = daytimeLight;
    }

    public boolean isEspSystem() {
        return espSystem;
    }

    public void setEspSystem(boolean espSystem) {
        this.espSystem = espSystem;
    }

    public int getNumberOfAirbag() {
        return numberOfAirbag;
    }

    public void setNumberOfAirbag(int numberOfAirbag) {
        this.numberOfAirbag = numberOfAirbag;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
