package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 *
 * an inner class is implicitly associated with an object of its outer class so
 *      it cannot define any static members(fields and methods) for itself excepts constants (static final).
 *      it has direct access to the outer class object's fields and methods
 * Types of Inner Classes:
 *      Local Classes
 *      Anonymous Classes
 */
public class NestedInnerClass {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.innerShow();
    }
}

class Outer{
    int n1 = 0;
    interface OuterInterface{}
    abstract class OuterAbstract{}
    void outerShow(){
        System.out.println("outerShow()");
    }
    class Inner{
        public Inner() {}
        //interface InnerInterface{}//not allowed
        abstract class InnerAbstract{}
        //static int n = 0;//not allowed
        static final int n = 0;//allowed
        void innerShow(){
            System.out.println("innerShow()");
            //direct access to the outer class object's fields and methods
            System.out.println(n1);
            outerShow();
        }
        //static void staticInnerShow(){ }//compile time error
    }
}
