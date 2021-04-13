package com.ab.core.oop;

import com.ab.core.oop.model.Calculators;
import com.ab.core.oop.model.ConversionHelper;

public class StaticDemo {
    public static void main(String[] args) {
        int altitudeInFeet = 28000;
        double distance = 10;

        int altitudeInFL = ConversionHelper.fromFeetToFL(300);
        System.out.println(altitudeInFeet + " ft -> FL " + altitudeInFL);

        double nmToMeters = ConversionHelper.fromNmToMeters(100);
        System.out.println(distance + " nm -> mt " +distance);

        Calculators.Distance d = new Calculators.Distance(1,1,3,3);
        System.out.println("Distance is " + d.calculate());
    }
}
