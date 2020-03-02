package com.ab.core.gc;

/**
 * @author Arpit Bhardwaj
 *
 *  * Object 1 references Object 2 and Object 2 references Object 1.
 *  * Neither Object 1 nor Object 2 is referenced by any other object. That’s an island of isolation.
 */
public class IslandOfIsolation {

    public static void main(String[] args) throws InterruptedException {
        ReferenceTestClass testObject1 = new ReferenceTestClass("Object1");
        ReferenceTestClass testObject2 = new ReferenceTestClass("Object2");

        testObject1.refObject = testObject2;
        testObject2.refObject = testObject1;

        testObject1 = null;
        testObject2 = null;

        System.gc();

        Thread.sleep(1000);
    }
}
