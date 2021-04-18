package com.ab.core.typecasting;

/**
 * @author Arpit Bhardwaj
 *
 * Widening, also known as upcasting
 * Widening Casting is automatic and called implicit conversion
 *
 * Widening is taking place when a small primitive type value is automatically accommodated in a bigger/wider primitive data type.
 * Widening is taking place when a reference variable of a subclass is automatically accommodated in the reference variable of its superclass.
 *
 * Java's widening conversions rules are,
 *
 * From a byte   ---> short ---> int ---> long ---> float ---> double
 * From a short  ---> int ---> long ---> float ---> double
 * From a char   ---> int ---> long ---> float ---> double
 * From an int    ---> long ---> float ---> double
 * From a long   ---> float ---> double
 * From a float   ---> double
 *
 * Widening of reference variable depends on inheritance tree
 * Ex. Integer cannot be widened to Long. But, Integer widened to Number because they are in same inheritance hierarchy).
 *
 *  Inheritance Hirarchy
 *
 *  Number implements Serializable
 *  Byte,Short,Integer,Long,Double,Float extends Number and implements Comparable
 *
 *  Character extends nothing implements Serializable and Comparable
 *  Boolean extends nothing implements Serializable and Comparable
 */
public class WideningDemo {
    public static void main(String[] args) {
        wideningPrimitives();
        wideningObjects();
    }

    private static void wideningObjects() {
        Integer i = new Integer(1);
        Number n = i;

        //Long l = i;//compile error
        //Float f = i;//compile error
    }

    private static void wideningPrimitives() {
        byte b = 10;

        short s = b;
        int i = b;
        long l = b;
        float f = b;
        double d = b;

        System.out.println("short value : "+ s);
        System.out.println("int value : "+ i);
        System.out.println("long value : "+ l);
        System.out.println("float value : "+ f);
        System.out.println("double value : "+ d);

        char c = 'x';
        //byte b1 = c;//compile error
        //short s1 = c;//compile error
        int i1 = c;
        long l1 = c;

    }
}
