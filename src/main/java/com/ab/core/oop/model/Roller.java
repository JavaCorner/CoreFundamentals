package com.ab.core.oop.model;

public interface Roller {
    int minOperatingTemp = -50;
    void start();
    void stop();

    default String healthCheck(){
        return "Roller";
    }
    private void test(){}
    static boolean canStart(int outsideTemp){
        return outsideTemp>minOperatingTemp;
    }
}
