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
 */
public class WideningDemo {
    public static void main(String[] args) {
        wideningPrimitives();
        wideningObjects();
    }

    private static void wideningObjects() {
        Integer integer = new Integer(1);
        Number number = integer;
        System.out.println(number);
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
    }
}
