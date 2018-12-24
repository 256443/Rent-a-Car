package com.antoszek.factoryMethod;

import com.antoszek.model.enumClass.CarClass;
import org.joda.time.DateTime;

public class FactoryInvoice {

    public double factoryCalculate(CarClass carClass, double numberOfDay){
        Calculate c = null;
        if(carClass.equals(CarClass.CLASS_A)){
            c = new ClassA();
        }
        else if(carClass.equals(CarClass.CLASS_B)){
            c = new ClassB();
        }
        else if(carClass.equals(CarClass.CLASS_C)){
            c= new ClassC();
        }
        else if(carClass.equals(CarClass.CLASS_CLASSIC)){
            c = new ClassClassic();
        }
        return c.calculate(numberOfDay);
    }
}
