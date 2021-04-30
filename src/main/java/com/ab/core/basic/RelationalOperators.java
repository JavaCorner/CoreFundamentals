package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * <	            Returns true if the value on the left is strictly less than the value on the right
 * <=	            Returns true if the value on the left is less than or equal to the value on the right
 * >	            Returns true if the value on the left is strictly greater than the value on the right
 * >=	            Returns true if the value on the left is greater than or equal to the value on the right
 * a instanceof b	Returns true if the reference that a points to is an instance of a class, subclass, or class that implements a particular interface, as named in b
 *
 *
 * It is common to use casting and instanceof together when working with objects that can be various different types,
 * since it can give you access to fields available only in the more specific classes.
 *
 * instanceof with incompatible types result in compilation error
 * instanceof on the null literal or a null reference always returns false.
 *
 */
public class RelationalOperators {
    public static void main(String[] args) {
        System.out.print(null instanceof Object);//false

        Object noObjectHere = null;
        System.out.print(noObjectHere instanceof String);//false

        //System.out.print(null instanceof null); // DOES NOT COMPILE
    }

    public static void openZoo(Number time) {
        if(time instanceof Integer)
            System.out.print((Integer)time + " O'clock");
        else
            System.out.print(time);

        //if(time instanceof String) // DOES NOT COMPILE
    }
}
