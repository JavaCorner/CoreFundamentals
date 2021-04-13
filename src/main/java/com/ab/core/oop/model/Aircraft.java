package com.ab.core.oop.model;
/**
 * @author Arpit Bhardwaj
 *
 * An abstract class is a class that is declared with abstract keyword.
 * An abstract method is a method that is declared without an implementation.
 *
 * An abstract class can contain 0 or multiple abstract methods
 * An abtract method can not exist in non abtract class
 *
 * An abstract class can not be directly instantiated with the new operator.
 * An abstract class can have parametrized constructors and default constructor.
 *
 * Usecase
 * Create Template for future classes and let them provide the actual implementation
 * Share some common functionality with future subclasses
 * Implement Template design pattern
 *
 */
public abstract class Aircraft {
    private int altitude;

    public final void land(){
        checkSystems();
        getClearance();
        implementActions();
    }

    public Aircraft(int altitude) {
        this.altitude = altitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public final void takeOff(){
        checkSystems();
        getClearance();
        implementActions();
    }

    protected abstract void checkSystems();
    protected abstract void getClearance();
    protected abstract void implementActions();
}
