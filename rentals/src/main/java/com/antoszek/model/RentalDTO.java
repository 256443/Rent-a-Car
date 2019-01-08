package com.antoszek.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

public class RentalDTO {

    private Long client_id;
    private Long car_id;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp dataFrom;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp dataTo;
    private double numberOfDay;

    public RentalDTO() {
    }

    public RentalDTO(Long car_id, Timestamp dataFrom, Timestamp dataTo, double numberOfDay) {
        this.car_id = car_id;
        this.dataFrom = dataFrom;
        this.dataTo = dataTo;
        this.numberOfDay = numberOfDay;
    }

    public double getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(double numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public Timestamp getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Timestamp dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Timestamp getDataTo() {
        return dataTo;
    }

    public void setDataTo(Timestamp dataTo) {
        this.dataTo = dataTo;
    }
}
