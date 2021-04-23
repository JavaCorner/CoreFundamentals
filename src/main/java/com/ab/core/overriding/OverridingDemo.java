package com.ab.core.overriding;

/**
 * @author Arpit Bhardwaj
 *
 */
public class OverridingDemo {

    static class Animal{
        int i = 11;
        void nonstaticFun(){
            System.out.println("Animal-nonstaticFun()-"+i);
        }
        static void staticFun(){
            System.out.println("Animal-staticFun()");
        }
    }
    static class Camel extends Animal{
        int i = 12;
        @Override
        void nonstaticFun() {
            System.out.println("Camel-nonstaticFun()-" + i);

        }

        static void staticFun(){
            System.out.println("Camel-staticFun()");
        }
    }

    public static void main(String[] args) {
        Animal a1 = new Camel();
        Animal a2 = new Animal();

        a1.nonstaticFun();
        a2.nonstaticFun();

        Camel.staticFun();
        Animal.staticFun();

    }
}

