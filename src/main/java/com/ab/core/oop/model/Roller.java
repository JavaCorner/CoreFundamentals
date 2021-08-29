package com.ab.core.oop.model;

public interface Roller {
    int MIN_OPERATING_TEMP = -50;
    void start();
    void stop();

    default String healthCheck(){
        return "OK";
    }
    private void test(){}
    static boolean canStart(int outsideTemp){
        return outsideTemp>MIN_OPERATING_TEMP;
    }
}
