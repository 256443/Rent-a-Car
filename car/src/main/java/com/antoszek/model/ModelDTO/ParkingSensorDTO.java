package com.antoszek.model.ModelDTO;

public class ParkingSensorDTO {

    private boolean parkingSensorFront;
    private boolean parkingSensorBack;
    private boolean parkingCamera;
    private boolean automaticParkingSystem;
    private Long car_id;

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

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }
}
