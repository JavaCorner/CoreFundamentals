package com.ab.core.overriding;

/**
 * @author Arpit Bhardwaj
 *
 * Before JDK 5.0
 * it was not possible to override a method by changing the return type
 * Overriding method was said to be invariant with respect to return type.
 *
 * After JDK 5.0
 * it is possible to have different return type for a overriding method in child class,
 * Overriding method becomes variant with respect to return type.
 *
 * Overriding method in Child class can either have same return type or should be Subclass of return type declared in method of Super class.
 */
public class ReturnType {
    public static void main(String[] args) {}
}

class A{
    protected Number connect(){
        return 1;
    };
}

class B extends A{
    @Override
    protected Integer connect() {
        return (Integer) super.connect();
    }
}
