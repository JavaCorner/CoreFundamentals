package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 *
 * Anonymous inner classes are declared without any name at all. They are created in two ways.
 *      a) As subclass of specified type
 *      b) As implementer of the specified interface
 *
 * Outer method local variables and parameters can only be accessed if they are final or effectively final
 * Constructors are not allowed
 */
public class AnonymousInnerClass {
    int a = 10;
    static int b = 20;
    public static void main(String[] args) {
        final int y = 11;   //can be used in local inner class
        int x = 10;         //here x is effectively final //can be used in local inner class
        int z = 12;
        z = 13;             //here z is nor final or effectively final//cannot use in local inner class
        Demo demo = new Demo();
        demo.display();

        //below anonymous classes are tied to main method, hence act as method local inner classes
        //variable tied to outer class (AnonymousInnerClass) are called outer class variables
        //variable tied to method(main) are called local variables. final and effectively final
        Demo subDemo = new Demo(){
            @Override
            void display() {
                System.out.println("Inside Anonymous subclass of Demo base class");
            }
        };
        subDemo.display();

        DemoAbstract demoAbstract = new DemoAbstract(){
            @Override
            void test() {}
        };
        demoAbstract.display();

        DemoInterface anonymousClass = new DemoInterface() {
            class innerClass{}
            //interface InnerInterface{}                                //interface not allowed
            abstract class InnerAbstract{}                              //abstract
            int n1 = 0;                                                 //nonstatic field
            //static int n2 = 0;                                        //static field not allowed
            void innerShow(){                                           //nonstatic method
                System.out.println("innerShow()");
                System.out.println("Inside inner method");
                //System.out.println("Accessing a : " + a);             //direct access to non-static outer class variables not allowed
                System.out.println("Accessing a : " + new AnonymousInnerClass().a);
                System.out.println("Accessing b : " + b);
                System.out.println("Accessing x : " + y);
                System.out.println("Accessing x : " + x);
                //System.out.println("Accessing x : " + z);//compile error
            }
            //static void staticInnerShow(){}                           //static method not allowed
            @Override
            public void display() {
                System.out.println("inside anonymous implementation of DemoInterface");
            }
        };
        anonymousClass.display();
    }
}

class Demo{
    void test(){};
    void display(){
        System.out.println("Inside Demo base class");
    }
}

abstract class DemoAbstract{
    abstract void test();
    void display(){
        System.out.println("Inside Demo base class");
    }
}

interface DemoInterface{
    void display();
}
