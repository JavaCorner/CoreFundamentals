package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * ASSIGNMENT OPERATOR RETURN VALUE
 * Assignment operator = does 2 things
 *  First, it sets the value of the variable
 *  Second, it returns a value of the assignment
 *
 * The EQUALITY OPERATOR are used in one of three scenarios:
 *
 * Comparing two numeric or character primitive types. If the numeric values are of different data types, the values are automatically promoted. For example, 5 == 5.00 returns true since the left side is promoted to a double.
 * Comparing two boolean values
 * Comparing two objects, including null and String values
 */

public class AssignmentEqualityOperator {
    public static void main(String[] args) {

        long wolf = 5;
        //(wolf=3) does two things. First, it sets the value of the variable wolf to be 3. Second, it returns a value of the assignment, which is also 3.
        long coyote = (wolf=3);
        System.out.println(wolf);   // 3


        boolean healthy = false;
        if(healthy = true)
            System.out.print("Good!");


        //boolean monkey = true == 3;       // DOES NOT COMPILE
        //boolean ape = false != "Grape";   // DOES NOT COMPILE
        //boolean gorilla = 10.2 == "Koko"; // DOES NOT COMPILE

        boolean bear = false;
        boolean polar = (bear = true);
        System.out.println(polar); //true
        System.out.print(null == null); //true
    }
}
