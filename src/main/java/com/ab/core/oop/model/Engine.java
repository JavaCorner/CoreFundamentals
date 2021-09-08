package com.ab.core.oop.model;

/**
 * @author Arpit Bhardwaj
 *
 * Fileds defined in interfaces are public static final by default. Specifying the same will be redundant
 * Interface methods are public and abtract by default.Specifying the same will be redundant
 *
 * Interface may contain default, private or static methods.
 *
 * Default methods
 *      by default public and are only allowed in interface
 *      help minimize code duplication
 *      can be overridden if necessary
 *
 * Static Methods
 *      by default public but you can also mark it as private
 * Iterface cannot contain constructors
 */

public interface Engine {

    int minOperatingTemp = -50;

    void start();
    void stop();

    default String healthCheck(){
        return "Engine";
    }
    private void test(){}

    static boolean canStart(int outsideTemp){
        return outsideTemp>minOperatingTemp;
    }
}
