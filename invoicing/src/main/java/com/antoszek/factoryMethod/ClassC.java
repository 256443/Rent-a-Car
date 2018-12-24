package com.antoszek.factoryMethod;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class ClassC implements Calculate {
    @Override
    public double calculate(double numberOfDay) {
        double przelicznik = 541.00;

        return numberOfDay*przelicznik;
    }
}
