package com.ab.core.oop.model;

/**
 * @author Arpit Bhardwaj
 *
 * Fileds defined in interfaces are public static final by default. Specifying the same will be redundant
 * Interface methods are public and abtract by default.Specifying the same will be redundant
 * Interface may contain default, private or static methods.
 * Iterface cannot contain constructors
 * Interface can only extend other interface.
 *
 * Default methods
 *      by default public
 *      only allowed in interface
 *      help minimize code duplication
 *      can be overridden if necessary
 *
 * Static Methods
 *      by default public, but you can also mark it as private
 */

public interface Engine /*extends AbstractEngine*/ {

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
