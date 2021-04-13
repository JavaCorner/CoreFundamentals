package com.ab.core.innerclass;

import javax.crypto.spec.PSource;

/**
 * @author Arpit Bhardwaj
 *
 * Static Nested classes are associated with outer class
 * Inner classes are associated with instance of outer class.
 *
 * Everything allowed except no direct access to outer class members
 */
public class NestedStaticInnerClass {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        Outer1.Inner.staticInnerShow();
        Outer1.Inner inner = new Outer1.Inner();//instance of static inner class in order to access non static methods
        inner.innerShow();
    }
}

class Outer1{
    int n = 0;
    interface OuterInterface{}
    abstract class OuterAbstract{}
    void outerShow(){
        System.out.println("outerShow()");
    };

    static class Inner{
        public Inner() {}
        interface InnerInterface{}
        abstract class InnerAbstract{}
        int n1 = 0;
        static int n2 = 0;
        static final int n3 = 0;
        void innerShow(){
            System.out.println("innerShow()");
        }
        static void staticInnerShow(){
            System.out.println("staticInnerShow()");
            //no direct access to the outer class object's fields and methods
            Outer1 o = new Outer1();
            System.out.println(o.n);
            o.outerShow();
        }
    }
}
