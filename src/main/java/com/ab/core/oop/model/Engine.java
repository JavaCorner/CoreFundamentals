package com.ab.core.oop.model;

/**
 * @author Arpit Bhardwaj
 *
 * Interface methods are abtract and public by default.Even though you can sepcify abtract and public but that will be redundant
 * Interface methods can not be protected or private
 * Fileds defined in interfaces are public static final by default. Specifying the same will be redundant
 * Default methods are by default public
 *
 * Iterface cannot contain constructors
 */

public interface Engine {
    int MIN_OPERATING_TEMP = -50;
    void start();
    void stop();

    default String healthCheck(){
        return "OK";
    }

    static boolean canStart(int outsideTemp){
        return outsideTemp>MIN_OPERATING_TEMP;
    }
}
