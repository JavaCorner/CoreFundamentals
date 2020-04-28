package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 *
 * Before JDK 1.8 : Method Local inner classes can’t use local variable of outer method until that local variable is not declared as final.
 */
public class MethodLocalInnerClass {
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.outerMethod();
    }
}

class Outer2{
    void outerMethod(){
        int x = 10;
        System.out.println("inside outer method");
        class Inner{
            void innerMethod(){
                System.out.println("Inside inner method");
                System.out.println("Accessing x : " + x);//Allowed jdk 1.8 onwards
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }
}
