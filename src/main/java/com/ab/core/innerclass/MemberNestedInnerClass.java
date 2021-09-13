package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 *
 * Member nested inner class
 *      is associated with an instance context of its outer class.
 *      are used for constraint use or to encapsulate logic
 *      it cannot define any static members(fields and methods) for itself excepts constants (static final).
 *      it has direct access to the outer class static and nonstatic fields and methods
 */
public class MemberNestedInnerClass {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.innerShow();
    }
}

class Outer{
    private int n = 0;
    interface OuterInterface{}
    abstract class OuterAbstract{}
    void outerShow(){
        System.out.println("outerShow()");
    }
    class Inner{
        public Inner() {}                       //constructor
        //interface InnerInterface{}            //Interface not allowed because interfaces are inherently static.
        abstract class InnerAbstract{}          //Abstract class
        int n1 = 0;                             //nonstatic field
        //static int n2 = 0;                    //static fields not allowed
        static final int n = 0;                 //constants
        void innerShow(){                       //nonstatic methods
            System.out.println("innerShow()");
            //direct access to the outer class object's fields and methods
            System.out.println(n);
            outerShow();
        }
        //static void staticInnerShow(){ }      //static methods not allowed
    }
}
