package com.ab.core.gc;

/**
 * @author Arpit Bhardwaj
 */
public class GarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        //Object created inside a method
        createObject();

        //Reassigning the reference variable
        TestClass testObject1 = new TestClass("Object3");
        TestClass testObject2 = new TestClass("Object4");
        testObject1 = testObject2;

        //Nullifying the reference variable
        TestClass testObject3 = new TestClass("Object5");
        testObject3 = null;

        //Anonymous object
        new TestClass("Object6");

        System.gc();
        Thread.sleep(2000);
    }

    private static void createObject() {
        TestClass testObject = new TestClass("Object1");
        display();
    }

    private static void display() {
        TestClass testObject = new TestClass("Object2");
    }
}
