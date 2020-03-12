package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 *
 * Anonymous inner classes are declared without any name at all. They are created in two ways.
 * a) As subclass of specified type
 * a) As implementer of the specified interface
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.display();
        Demo subDemo = new Demo(){
            @Override
            void display() {
                //super.display();
                System.out.println("Inside Anonymous subclass of Demo base class");
            }
        };
        subDemo.display();

        DemoInterface anonymous = new DemoInterface() {
            @Override
            public void display() {
                System.out.println("inside anonymous implementation of DemoInterface");
            }
        };
        anonymous.display();
    }
}

class Demo{
    void display(){
        System.out.println("Inside Demo base class");
    }
}

interface DemoInterface{
    void display();
}
