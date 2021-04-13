package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 * Apply Rules of Nested inner classes
 * can access the variables defined in the same scope but the variables must be final or effectively final
 * Local inner classes are defined and access only with in the scope in which they defined in
 * Access modifer not allowed for local inner class
 * Constructor is allowed
 */
public class MethodLocalInnerClass {
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.outerMethod();
    }
}

class Outer2{
    void outerMethod(){
        final int y = 11;//can be used in local inner class
        int x = 10;//here x is effectively final //can be used in local inner class
        int z = 12;
        z = 13;//here z is nor final or effectively final//cannot use in local inner class
        System.out.println("inside outer method");
        class Inner{
            public Inner() {}
            void innerMethod(){
                System.out.println("Inside inner method");
                System.out.println("Accessing x : " + y);
                System.out.println("Accessing x : " + x);
                //System.out.println("Accessing x : " + z);//compile error
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }
    void test(){
    }
}
