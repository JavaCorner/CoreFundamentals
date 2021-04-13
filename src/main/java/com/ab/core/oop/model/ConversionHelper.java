package com.ab.core.oop.model;

/**
 * @author Arpit Bhardwaj
 *
 * Static method are perfect fit to create utility methods
 * Static methods and static blocks cannot directly use non static fields and methods, in order to use they need a object reference
 * Static methods can use static fields and methods directly
 */
public class ConversionHelper {

    private int kmToMeters = 1000;
    private static int metersInOneNm;

    static {
        System.out.println("static initializer");
        //System.out.println(kmToMeters);//compile error as n is non static
        metersInOneNm = 1852;
    }

    public static int fromFeetToFL(int feet){
        return feet / 100;
    }

    public static double fromNmToMeters(double nm){
        //System.out.println(kmToMeters);//compile error as kmToMeters is non static
        //fromKmToMeters(100);//compile error as fromKmToMeters is non static
        return nm * metersInOneNm;
    }

    public double fromKmToMeters(double km){
        //System.out.println(metersInOneNm); //valid
        //fromNmToMeters(100); //valid
        return km * kmToMeters;
    }
}
