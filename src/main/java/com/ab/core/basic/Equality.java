package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * "==" compare two objects based on memory reference.
 * "==" operator will return true only if two object reference it is comparing represent exactly same object otherwise "==" will return false.
 *
 *
 * Hence In terms of comparing primitives like boolean, int, float "==" works fine
 * but when it comes to comparing objects it creates confusion with equals method in Java.
 * After the introduction of Autoboxing and unboxing in Java 5, using == to compare wrapper objects even become trickier
 *
 */
public class Equality {
    public static void main(String[] args) {
        //for primitive as use == as equals works only with object
        //primitivesComparison();
        //for objects as per best practise use equals till you don't want to equate reference address

        objectComparison();
    }

    private static void objectComparison() {
        //stringComparison();
        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println(obj1 == obj2);
        //Default implementation of equals provided in Object class is similar to "==" equality operator
        System.out.println(obj1.equals(obj2));
    }

    private static void stringComparison() {
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println(s1.equals(s2));//String class overrides equals
        System.out.println(s1==s2);//allowed but not suppose to be used as it does reference comparison

        String s3 = "Hello";
        System.out.println(s1.equals(s3));
        System.out.println(s1==s3);
    }

    private static void primitivesComparison() {
        System.out.println(10 == 10);
        System.out.println(10 == 20);
        System.out.println('a' == 'a');
        System.out.println('a' == 'b');
        System.out.println(true == true);
    }
}
