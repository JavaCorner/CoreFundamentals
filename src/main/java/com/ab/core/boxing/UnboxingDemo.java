package com.ab.core.boxing;

/**
 * @author Arpit Bhardwaj
 *
 * Opposite of Autoboxing is unboxing
 *
 * intValue() and similar to get primitive value from Wrapper Object.
 * parseInt() and similar are used to covert string to primitive which may throw exception in case of invalid conversion
 */
public class UnboxingDemo {
    public static void main(String[] args) {
        //before Java 5 (explicit conversion from object to primitive)
        Integer int1 = Integer.valueOf(2);
        int int2 = int1.intValue();
        int int3 = Integer.parseInt("12");
        //int int4 = Integer.parseInt("a");//throws NumberFormatException

        //after java 5 (taken care by compiler)
        int int5 = int1;
    }
}
