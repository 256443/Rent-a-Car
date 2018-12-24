package com.antoszek.factoryMethod;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class ClassB implements Calculate {
    @Override
    public double calculate(double numberOfDay) {
        double przelicznik = 641.00;

        return numberOfDay*przelicznik;
    }
}
