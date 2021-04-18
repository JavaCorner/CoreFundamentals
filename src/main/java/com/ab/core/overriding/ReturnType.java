package com.ab.core.overriding;

/**
 * @author Arpit Bhardwaj
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
