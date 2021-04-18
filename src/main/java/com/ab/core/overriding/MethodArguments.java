package com.ab.core.overriding;

/**
 * @author Arpit Bhardwaj
 *
 * Total number and type of arguments present in overriding Child class method must be exactly same as that of Parent class method.
 *
 * Note:
 * Arguments present in Child class method should be exactly of same type (Subclass will not work) as that of Parent class method.
 */

class A1{}
class A2 extends A1{}
class A3 extends A1{}

class Parent{
    protected Number connect(A1 a, A3 b){
        return null;
    };
}

class Child extends Parent{
    @Override
    protected Number connect(A1 a, A3 b) {
        return null;
    }
}
public class MethodArguments {
    public static void main(String[] args) {

    }
}
