package com.antoszek.model.ModelDTO;

import com.antoszek.model.enumClass.TypeOfDrive;

import javax.persistence.Enumerated;

public class SecurityDTO {
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
    private Long car_id;


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

    public boolean isAbsSystem() {
        return absSystem;
    }

    public void setAbsSystem(boolean absSystem) {
        this.absSystem = absSystem;
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

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }
}
