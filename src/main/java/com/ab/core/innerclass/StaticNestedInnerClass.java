package com.ab.core.innerclass;

import javax.crypto.spec.PSource;

/**
 * @author Arpit Bhardwaj
 *
 * Static Nested classes are associated with static context of outer class
 *        Everything allowed except no direct access to outer class nonstatic members
 */
public class StaticNestedInnerClass {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        Outer1.Inner.staticInnerShow();
        Outer1.Inner inner = new Outer1.Inner();//instance of static inner class in order to access nonstatic methods
        inner.innerShow();
    }
}

class Outer1{
    private int n = 0;
    private static int n4 = 0;
    interface OuterInterface{}
    abstract class OuterAbstract{}
    void outerShow(){
        System.out.println("outerShow()");
    };

    static class Inner{
        public Inner() {}                                       //constructor
        interface InnerInterface{}                              //interface
        abstract class InnerAbstract{}                          //abstract
        int n1 = 0;                                             //nonstatic field
        static int n2 = 0;                                      //static field
        void innerShow(){
            System.out.println("innerShow()");
        } //nonstatic method
        static void staticInnerShow(){                          //static method
            System.out.println("staticInnerShow() " + n4);
            //no direct access to the outer class nonstatic fields and methods
            Outer1 o = new Outer1();
            System.out.println(o.n);
            o.outerShow();
        }
    }
}
