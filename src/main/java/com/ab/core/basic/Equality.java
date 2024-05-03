package com.ab.core.basic;

import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 *
 * "==" compare two objects based on memory reference.
 *      true if exactly same object else false
 *
 * Hence, In terms of comparing primitives like boolean, int, float "==" works fine
 * but when it comes to comparing objects it creates confusion with equals method in Java.
 * After the introduction of Autoboxing and unboxing in Java 5, using == to compare wrapper objects even become trickier
 *
 */
public class Equality {
    public static void main(String[] args) {
        //for primitive use == since equals works only with object
        primitivesComparison();
        //for objects as per best practices use overridden equals method since you don't want to equate reference address
        objectComparison();
        stringComparison();
        arrayComparison();
    }

    private static void primitivesComparison() {
        System.out.println("*******Primitives Comparison******");
        System.out.println(10 == 10);       //true
        System.out.println(10 == 20);       //false
        System.out.println('a' == 'a');     //true
        System.out.println('a' == 'b');     //false
        System.out.println(true == true);   //true
    }

    private static void objectComparison() {
        System.out.println("*******Object Comparison******");
        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println(obj1 == obj2);       //false
        //Default implementation of equals provided in Object class is similar to "==" equality operator
        System.out.println(obj1.equals(obj2));  //false
    }

    private static void stringComparison() {
        System.out.println("*******String Comparison******");
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        //String class overrides equals
        System.out.println(s1.equals(s2));  //true
        System.out.println(s1==s2);         //false //allowed but not suppose to be used as it does reference comparison

        String s3 = "Hello";
        System.out.println(s1.equals(s3));  //true
        System.out.println(s1==s3);         //false

        String x = "Hello World";
        String y = "Hello World";
        System.out.println(x == y);         //true

        String x1 = "Hello World";
        String z1 = " Hello World".trim();
        System.out.println(x1 == z1);       //false
    }


    private static void arrayComparison() {
        System.out.println("*******Array Comparison******");
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,2,3};
        System.out.println(arr1 == arr2);               //false
        System.out.println(arr1.equals(arr2));          //false
        System.out.println(Arrays.equals(arr1,arr2));   //true
    }
}
