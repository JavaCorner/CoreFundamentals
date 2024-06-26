package com.ab.core.basic;

import java.util.ArrayList;

/**
 * @author Arpit Bhardwaj
 *
 * Automatically convert the primitive type into wrapper
 * After Java 5 compiler implicitly uses valueOf() method to convert primitive to respective wrapper Object
 * valueOf is also used for converting String to a wrapper class which may throw exception in case of invalid conversion
 *
 * Wrapper class	Converting String to a primitive	Converting String to a wrapper class
 * Boolean	        Boolean.parseBoolean("true")	    Boolean.valueOf("TRUE")
 * Byte	            Byte.parseByte("1")	                Byte.valueOf("2")
 * Short	        Short.parseShort("1")	            Short.valueOf("2")
 * Integer	        Integer.parseInt("1")	            Integer.valueOf("2")
 * Long	            Long.parseLong("1")	                Long.valueOf("2")
 * Float	        Float.parseFloat("1")	            Float.valueOf("2.2")
 * Double	        Double.parseDouble("1")	            Double.valueOf("2.2")
 * Character	    None	                            None
 *
 * The wrapper classes are immutable and take advantage of some caching as well.
 *
 * Opposite of Autoboxing is unboxing
 *
 * xxxValue() and similar to get primitive value from Wrapper Object.
 * parseXxx() and similar are used to covert string to primitive which may throw exception in case of invalid conversion
 */

public class BoxingDemo {
    public static void main(String[] args) {
        autoBoxing();
        unBoxing();
    }

    private static void unBoxing() {
        //before Java 5 (explicit conversion from object to primitive)
        Integer int1 = Integer.valueOf(2);
        int int2 = int1.intValue();
        int int3 = Integer.parseInt("12");
        //int int4 = Integer.parseInt("a");//throws NumberFormatException

        //after java 5 (taken care by compiler)
        int int5 = int1;
    }

    private static void autoBoxing() {
        //before Java 5 (explicit conversion from primitive to wrapper)
        Integer int1 = Integer.valueOf(2);
        //after java 5 (taken care by compiler)
        Integer int2 = 3;

        Integer int3 = Integer.valueOf("2");
        //Integer int4 = Integer.valueOf("a");//throws NumberFormatException

        autoboxingInCollection();
        autoboxingInMethods(3);
    }

    private static void autoboxingInMethods(Integer integer) {
        System.out.println(integer.intValue());
    }

    private static void autoboxingInCollection() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(null);
        Integer i1 = list.get(0);
        Integer i2 = list.get(2);
        //int i3 = list.get(2);//throws NullPointerException as java tries to do implicit unboxing here
        //list.remove(1);//this will remove the value at index 1 means element 2 in case you want to remove element 1
        //list.remove(new Integer(1));
        System.out.println(list);
    }
}
