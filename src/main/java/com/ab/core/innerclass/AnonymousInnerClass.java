package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 *
 * Anonymous inner classes are declared without any name at all. They are created in two ways.
 * a) As subclass of specified type
 * a) As implementer of the specified interface
 *
 * Applied Rules of Local Inner Class except constructors are not allowed
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
            int i = 0;
            void test(){};
            class test{}
            {}
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
