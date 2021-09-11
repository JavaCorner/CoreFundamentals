package com.ab.core.oop.model;

/**
 * @author Arpit Bhardwaj
 *
 * You cannot override sttaic methods even though you can have the same method signature without @override annotation
 */
public class Helicopter extends Aircraft{

    private String colour;

    public Helicopter(int altitude) {
        super(altitude);
    }

    //widen the visibility from package-private to protected
    @Override
    protected void checkSystems() {}

    @Override
    protected void getClearance() {}

    @Override
    public void implementActions() {}

    //@Override //static methods cannot be overridden
    public static void aircraftDimensions(){

    }
}
