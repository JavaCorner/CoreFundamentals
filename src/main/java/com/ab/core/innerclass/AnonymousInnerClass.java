package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 *
 * Anonymous inner classes are declared without any name at all. They are created in two ways.
 * a) As subclass of specified type
 * a) As implementer of the specified interface
 *
 * Outer method local variables and parameters can only be accessed if they are final or effectively final
 * Constructors are not allowed
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.display();
        Demo subDemo = new Demo(){
            @Override
            void display() {
                System.out.println("Inside Anonymous subclass of Demo base class");
            }
        };
        subDemo.display();

        DemoInterface anonymous = new DemoInterface() {
            class innerClass{}
            //interface InnerInterface{}                                //interface not allowed
            abstract class InnerAbstract{}                              //abstract
            int n1 = 0;                                                 //nonstatic field
            //static int n2 = 0;                                        //static field not allowed
            void innerShow(){
                System.out.println("innerShow()");
            }     //nonstatic method
            //static void staticInnerShow(){}                           //static method not allowed
            @Override
            public void display() {
                System.out.println("inside anonymous implementation of DemoInterface");
            }
        };
        anonymous.display();
    }
}

class Demo{
    void test(){};
    void display(){
        System.out.println("Inside Demo base class");
    }
}

interface DemoInterface{
    void display();
}
