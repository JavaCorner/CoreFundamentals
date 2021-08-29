package com.ab.core.oop.model;

/**
 * @author Arpit Bhardwaj
 *
 * You cannot override sttaic methods even though you can have the same method signature without @override annotation
 */
public class Helicopter extends Aircraft{

    public Helicopter(int altitude) {
        super(altitude);
    }

    @Override
    protected void checkSystems() {

    }

    @Override
    protected void getClearance() {

    }

    @Override
    protected void implementActions() {

    }

    //@Override //uncomment will result in compiler error
    public static void aircraftDimensions(){

    }
}
