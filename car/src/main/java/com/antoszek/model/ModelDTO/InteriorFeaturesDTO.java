package com.antoszek.model.ModelDTO;

import com.antoszek.model.entityClass.Car;
import com.antoszek.model.enumClass.AirConditioning;

import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static javax.persistence.EnumType.STRING;

public class InteriorFeaturesDTO {
    private boolean skiRack;
    private boolean bluetooth;
    private boolean centralLocking;
    private boolean rainSensor;
    private boolean electricalWindows;
    private boolean electricalMirror;
    private boolean electricSeatAdjustment; //elektrycznie regulowane tylne siedzenia;
    private boolean MP3interface;
    private boolean isofixSystem;
    private boolean on_boardComputer;
    private boolean CDPlayer;
    private boolean heatedSeats; //podgrzewane fotele
    private boolean radioFM;
    private boolean navigationSystem;
    private boolean startStopSystem;
    private boolean sunroof; //szyberdach
    private boolean cruiseControl; //tempomat
    private boolean ventilatedSeats; //wentylowane fotele
    private boolean multifunctionSteeringWheel; //wielofunkcyjna kierownica
    private boolean powerSteering; //wspomaganie kierownicy
    private boolean touchScreen;
    private boolean loudspeekerSysetm;
    @Enumerated
    private AirConditioning airConditioning;
    private Long car_id;

    public AirConditioning getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(AirConditioning airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isSkiRack() {
        return skiRack;
    }

    public void setSkiRack(boolean skiRack) {
        this.skiRack = skiRack;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isCentralLocking() {
        return centralLocking;
    }

    public void setCentralLocking(boolean centralLocking) {
        this.centralLocking = centralLocking;
    }

    public boolean isRainSensor() {
        return rainSensor;
    }

    public void setRainSensor(boolean rainSensor) {
        this.rainSensor = rainSensor;
    }

    public boolean isElectricalWindows() {
        return electricalWindows;
    }

    public void setElectricalWindows(boolean electricalWindows) {
        this.electricalWindows = electricalWindows;
    }

    public boolean isElectricalMirror() {
        return electricalMirror;
    }

    public void setElectricalMirror(boolean electricalMirror) {
        this.electricalMirror = electricalMirror;
    }

    public boolean isElectricSeatAdjustment() {
        return electricSeatAdjustment;
    }

    public void setElectricSeatAdjustment(boolean electricSeatAdjustment) {
        this.electricSeatAdjustment = electricSeatAdjustment;
    }

    public boolean isMP3interface() {
        return MP3interface;
    }

    public void setMP3interface(boolean MP3interface) {
        this.MP3interface = MP3interface;
    }

    public boolean isIsofixSystem() {
        return isofixSystem;
    }

    public void setIsofixSystem(boolean isofixSystem) {
        this.isofixSystem = isofixSystem;
    }

    public boolean isOn_boardComputer() {
        return on_boardComputer;
    }

    public void setOn_boardComputer(boolean on_boardComputer) {
        this.on_boardComputer = on_boardComputer;
    }

    public boolean isCDPlayer() {
        return CDPlayer;
    }

    public void setCDPlayer(boolean CDPlayer) {
        this.CDPlayer = CDPlayer;
    }

    public boolean isHeatedSeats() {
        return heatedSeats;
    }

    public void setHeatedSeats(boolean heatedSeats) {
        this.heatedSeats = heatedSeats;
    }

    public boolean isRadioFM() {
        return radioFM;
    }

    public void setRadioFM(boolean radioFM) {
        this.radioFM = radioFM;
    }

    public boolean isNavigationSystem() {
        return navigationSystem;
    }

    public void setNavigationSystem(boolean navigationSystem) {
        this.navigationSystem = navigationSystem;
    }

    public boolean isStartStopSystem() {
        return startStopSystem;
    }

    public void setStartStopSystem(boolean startStopSystem) {
        this.startStopSystem = startStopSystem;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public boolean isVentilatedSeats() {
        return ventilatedSeats;
    }

    public void setVentilatedSeats(boolean ventilatedSeats) {
        this.ventilatedSeats = ventilatedSeats;
    }

    public boolean isMultifunctionSteeringWheel() {
        return multifunctionSteeringWheel;
    }

    public void setMultifunctionSteeringWheel(boolean multifunctionSteeringWheel) {
        this.multifunctionSteeringWheel = multifunctionSteeringWheel;
    }

    public boolean isPowerSteering() {
        return powerSteering;
    }

    public void setPowerSteering(boolean powerSteering) {
        this.powerSteering = powerSteering;
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public boolean isLoudspeekerSysetm() {
        return loudspeekerSysetm;
    }

    public void setLoudspeekerSysetm(boolean loudspeekerSysetm) {
        this.loudspeekerSysetm = loudspeekerSysetm;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }
}
