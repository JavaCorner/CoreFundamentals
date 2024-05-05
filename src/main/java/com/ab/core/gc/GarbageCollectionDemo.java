package com.ab.core.gc;

/**
 * @author Arpit Bhardwaj
 */
public class GarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        //Object created inside a method
        createObject();

        //Reassigning the reference variable
        TestClass testObject1 = new TestClass("Object2");
        TestClass testObject2 = new TestClass("Object3");
        testObject1 = testObject2;

        //Nullifying the reference variable
        TestClass testObject3 = new TestClass("Object4");
        testObject3 = null;

        //Anonymous object
        new TestClass("Object5");

        System.gc();
        Thread.sleep(2000);
    }

    private static void createObject() {
        TestClass testObject = new TestClass("Object1");
    }
}
