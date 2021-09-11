package com.ab.core.overriding;

/**
 * @author Arpit Bhardwaj
 *
 * overriding is only applicable to methods
 * variables in do not follow polymorphism
 *
 */
public class OverridingDemo {

    static class Animal{
        public int i = 11;

        void nonstaticFun(){
            System.out.println("Animal-nonstaticFun()-"+i);
        }
        static void staticFun(){
            System.out.println("Animal-staticFun()");
        }
    }
    static class Camel extends Animal{
        private int i = 12;
        @Override
        void nonstaticFun() {
            System.out.println("Camel-nonstaticFun()-" + i);
        }
        //@Override//compile error as it doesn't override superclass method
        static void staticFun(){
            System.out.println("Camel-staticFun()");
        }
    }

    public static void main(String[] args) {
        Animal a1 = new Camel();
        Animal a2 = new Animal();

        a1.nonstaticFun();
        a2.nonstaticFun();

        a1.staticFun();
        a2.staticFun();

        Camel.staticFun();
        Animal.staticFun();

        System.out.println(a1.i); //11
        System.out.println(a2.i); //11

    }
}

