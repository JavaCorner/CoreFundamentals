package com.ab.core.oop.model;

/**
 * @author Arpit Bhardwaj
 *
 * Private methods do not cause conflicts , because they are not visible outside of that interface.
 * Static methods do not cause conflicts, because they are invoked via specific parent types and do not rely on super ref
 * Default methods may create conflicts which must be resolved by overriding default method with in implementation class
 *
 */
public class WaterEngine implements Engine, Roller{
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
    //You must override default methods if it conflicts with another default method with same signature from other interface
    // as happening here. IF you don't it leads to compiler error
    @Override
    public String healthCheck() {
        return "Water Engine Ok";
    }

}
