package com.ab.core.overriding;

/**
 * @author Arpit Bhardwaj
 *
 * Overriding method in Child class can either have same return type or should be Subclass of return type declared in method of Super class.
 */
public class ReturnType {

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

class C extends A{
    @Override
    protected Long connect() {
        return (Long) super.connect();
    }
}

class D extends A{
    @Override
    protected Double connect() {
        return (Double) super.connect();
    }
}
