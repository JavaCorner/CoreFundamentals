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
 * From a byte     ---> char
 * From a short    ---> byte ---> char
 * From a char     ---> byte ---> short
 * From an int     ---> byte ---> short ---> char
 * From a long     ---> byte ---> short ---> char ---> int
 * From a float    ---> byte ---> short ---> char ---> int ---> long
 * From a double   ---> byte ---> short ---> char ---> int ---> long ---> float
 *
 * Overflow is when a number is so large that it will no longer fit within the data type,
 * so the system “wraps around” to the lowest negative value and counts up from there, similar to how modulus arithmetic works.
 *
 * Underflow, when the number is too low to fit in the data type
 */
public class NarrowingDemo {
    public static void main(String[] args) {
        //in below examples putting a larger value into a smaller data type.
        //float egg = 2.0 / 9;              // DOES NOT COMPILE double -> float
        //int tadpole = (int)5 * 2L;        // DOES NOT COMPILE long -> int
        //short frog = 3 - 2.0;             // DOES NOT COMPILE double -> short
        //int fish = 1.0;                   // DOES NOT COMPILE double -> int
        //short bird = 1921222;             // DOES NOT COMPILE int -> short
        //int mammal = 9f;                  // DOES NOT COMPILE float -> int
        //long reptile = 192301398193810323;// DOES NOT COMPILE literal is exceeding the int range

        //fixes for above statements through down casting, but it involves cost of OVERFLOW AND UNDERFLOW
        int fish = (int)1.0;
        System.out.println(fish);           //1

        //overflow
        short bird = (short)1921222;
        System.out.println(bird);           //20678
        int mammal = (int)9f;
        System.out.println(mammal);         //9
        long reptile = 192301398193810323L;
        System.out.println(reptile);        //192301398193810323
        //underflow
        byte rat = (byte) -200;
        System.out.println(rat);            //56

        narrowingPrimitives();
        narrowingObjects();
    }

    private static void narrowingObjects() {
        Number n = 10;                    //int will be wrapped to Integer and assigned to Number reference
        Integer i1 = (Integer) n;
        Long l = new Long(10);
        //Integer i2 = (Integer) l;       //compile error (Long and Integer are in different hierarchy, hence narrowing doesn't work)
        Long l2 = (Long) n;               //throws class cast exception
    }

    private static void narrowingPrimitives() {
        double d = 10;
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
