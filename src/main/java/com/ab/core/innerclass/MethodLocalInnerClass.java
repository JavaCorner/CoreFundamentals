package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 * Apply Rules of Member nested inner classes
 *      can only associate with instance context of its outer class
 *      Outer method local variables and parameters can only be accessed if they are final or effectively final
 *      Access modifer not allowed for local inner class
 *      outer method can be static or non-static
 */
public class MethodLocalInnerClass {
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.outerMethod();
    }
}

class Outer2{
    int a = 10;
    static int b = 20;
    void outerMethod(){
        final int y = 11;   //can be used in local inner class
        int x = 10;         //here x is effectively final //can be used in local inner class
        int z = 12;
        z = 13;             //here z is nor final or effectively final//cannot use in local inner class
        System.out.println("inside outer method");
        class Inner{
            public Inner() {}                                           //constructor
            //interface InnerInterface{}                                //interfaces not allowed
            abstract class InnerAbstract{}                              //abstract
            int n1 = 0;                                                 //nonstatic field
            //static int n2 = 0;                                        //static field not allowed
            static final int n3 = 0;                                    //constants
            void innerMethod(){                                         //nonstatic method
                System.out.println("Inside inner method");
                System.out.println("Accessing a : " + a);
                System.out.println("Accessing b : " + b);
                System.out.println("Accessing x : " + y);
                System.out.println("Accessing x : " + x);
                //System.out.println("Accessing x : " + z);//compile error
            }
            //static void staticInnerShow(){ }                          //static methods not allowed
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }
    void test(){
    }
}
