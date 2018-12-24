package com.antoszek.factoryMethod;


import org.joda.time.DateTime;


import java.sql.Timestamp;

public class ClassA implements Calculate {
    @Override
    public double calculate(double numberOfDay) {
        double przelicznik = 741.00;

        return numberOfDay*przelicznik;
    }
}
