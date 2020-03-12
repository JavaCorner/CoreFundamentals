package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 */
public class NestedStaticInnerClass {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        Outer1.Inner.staticShow();
        Outer1.Inner inner = new Outer1.Inner();
        inner.show();
    }
}

class Outer1{
    interface InnerInterface{
        void display();
    }
    static class Inner{
        public static final String var = "Static Final Variable Dec are possible";
        public void show(){
            System.out.println("Inside nested inner class non static method");
        }
        public static void staticShow(){
            System.out.println("Inside nested inner class static method");
        }
    }
}
