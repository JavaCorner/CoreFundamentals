package com.ab.core.oop.model;

public class Gear {
    int minOperatingTemp = -50;
    public String healthCheck(){
        return "Gear";
    }
    boolean canStart(int outsideTemp){
        return outsideTemp>minOperatingTemp;
    }
}
