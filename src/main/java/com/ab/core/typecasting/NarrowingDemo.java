package com.ab.core.typecasting;

/**
 * @author Arpit Bhardwaj
 *
 * Narrowing also known as downcasting/casting is a conversion that takes place in such situations -
 * Narrowing a wider/bigger primitive type value to a smaller primitive type value.
 * Narrowing the superclass reference to the reference of its subclass, during inheritance.
 *
 * Narrowing is manual and called explicit conversion
 *
 * Java's Narrow conversions rules are,
 *
 * From a byte     ---> char
 * From a short    ---> byte ---> char
 * From a char     ---> byte ---> short
 * From an int      ---> byte ---> short ---> char
 * From a long     ---> byte ---> short ---> char ---> int
 * From a float     ---> byte ---> short ---> char ---> int ---> long
 * From a double  ---> byte ---> short ---> char ---> int ---> long ---> float
 */
public class NarrowingDemo {
    public static void main(String[] args) {
        narrowingPrimitives();
        narrowingObjects();
    }

    private static void narrowingObjects() {

    }

    private static void narrowingPrimitives() {
        double d = 10.5;
        byte b = (byte) d;
        short s = (short) d;
        char c = (char) d;
        int i = (int) d;
        long l = (long) d;
        float f = (float) d;

        System.out.println("Original double value : " +d);
        System.out.println("Narrowing double value to byte : "+ b);
        System.out.println("Narrowing double value to short : "+ s);
        System.out.println("Narrowing double value to char : "+ c);
        System.out.println("Narrowing double value to int : "+ i);
        System.out.println("Narrowing double value to long : "+ l);
        System.out.println("Narrowing double value to float : "+ f);

    }
}
