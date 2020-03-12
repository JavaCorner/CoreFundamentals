package com.ab.core.innerclass;

/**
 * @author Arpit Bhardwaj
 *
 * an inner class is implicitly associated with an object of its outer class so it cannot define any static method for itself.
 */
public class NestedInnerClass {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
    }
}

class Outer{
    interface InnerInterface{
        void display();
    }
    class Inner{
        public static final String var = "Static Final Variable Dec are possible";
        public void show(){
            System.out.println("Inside nested inner class");
            System.out.println(var);
        }
        //public static void staticShow(){ }//compile time error
    }
}
