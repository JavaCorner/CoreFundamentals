package com.ab.core.boxing;

/**
 * @author Arpit Bhardwaj
 *
 * Opposite of Autoboxing is unboxing
 * and uses intValue(), doubleValue() etc to get primitive value from Object.
 */
public class UnboxingDemo {
    public static void main(String[] args) {
        //before Java 5 (explicit conversion from object to primitive)
        Integer int1 = Integer.valueOf(2);
        int int2 = int1.intValue();
        System.out.println(int2);
        //after java 5 (taken care by compiler)
        int int3 = int1;
        System.out.println(int3);

    }
}
