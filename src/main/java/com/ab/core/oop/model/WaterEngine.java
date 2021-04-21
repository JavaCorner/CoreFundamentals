package com.ab.core.oop.model;

public class WaterEngine implements Engine{
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    //You can override default methods
    @Override
    public String healthCheck() {

        return "Water Engine Ok";
    }

}
