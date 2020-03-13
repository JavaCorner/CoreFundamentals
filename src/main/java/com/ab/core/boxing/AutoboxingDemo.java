package com.ab.core.boxing;

import java.util.ArrayList;

/**
 * @author Arpit Bhardwaj
 *
 * automatically convert the primitive type into boxed primitive( Object or Wrapper class
 * Compiler uses valueOf() method to convert primitive to Object
 *
 *
 */
public class AutoboxingDemo {
    public static void main(String[] args) {
        //before Java 5 (explicit conversion from primitive to object)
        Integer int1 = Integer.valueOf(2);
        //after java 5 (taken care by compiler)
        Integer int2 = 3;

        autoboxingInCollection();
        autoboxingInMethods(3);
    }

    private static void autoboxingInMethods(Integer integer) {}

    private static void autoboxingInCollection() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
    }
}
