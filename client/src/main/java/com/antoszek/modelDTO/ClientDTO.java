package com.antoszek.modelDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class ClientDTO {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private boolean drivingLicense;
    private Date sinceDrivingLicense;
    private String emailAdress;
    private Long car_id;

    public ClientDTO() {
    }

    public ClientDTO(String firstName, String lastName, int age, boolean drivingLicense, Date sinceDrivingLicense, String emailAdress, Long car_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.drivingLicense = drivingLicense;
        this.sinceDrivingLicense = sinceDrivingLicense;
        this.emailAdress = emailAdress;
        this.car_id = car_id;
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(boolean drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Date getSinceDrivingLicense() {
        return sinceDrivingLicense;
    }

    public void setSinceDrivingLicense(Date sinceDrivingLicense) {
        this.sinceDrivingLicense = sinceDrivingLicense;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }
}
