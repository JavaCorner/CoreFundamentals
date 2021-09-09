package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * Assignment Opeartor
 *
 * Assignment operator = does 2 things
 *      First, it sets the value of the variable
 *      Second, it returns a value of the assignment
 *
 * Equality operator
 *
 *      Comparing two numeric or character primitive types.
 *          If the numeric values are of different data types, the values are automatically promoted.
 *          For example, 5 == 5.00 returns true since the left side is promoted to a double.
 *      Comparing two boolean values
 *      Comparing two objects, including null and String values
 *
 * Logical operators
 *
 * &	Logical AND is true only if both values are true.
 * |	Inclusive OR is true if at least one of the values is true.
 * ^	Exclusive XOR is true only if one value is true and the other is false.
 *
 * Tip:
 *      AND is only true if both operands are true.
 *      Inclusive OR is only false if both operands are false.
 *      Exclusive OR is only true if the operands are different.
 *
 * Short-circuit operators
 *
 * &&	Short-circuit AND is true only if both values are true. If the left side is false, then the right side will not be evaluated.
 * ||	Short-circuit OR is true if at least one of the values is true. If the left side is true, then the right side will not be evaluated.
 *
 * A more common example of where short-circuit operators are used is checking for null objects before performing an operation.
 *
 * Relational Operators
 *
 * <	            Returns true if the value on the left is strictly less than the value on the right
 * <=	            Returns true if the value on the left is less than or equal to the value on the right
 * >	            Returns true if the value on the left is strictly greater than the value on the right
 * >=	            Returns true if the value on the left is greater than or equal to the value on the right
 * a instanceof b	Returns true if the reference that "a" points to is an instance of a class, subclass, or class that implements a particular interface, as named in "b"
 *
 * It is common to use casting and instanceof together when working with objects that can be various different types,
 * since it can give you access to field available only in the more specific classes.
 *
 * instanceof with incompatible types result in compilation error
 * instanceof on the null literal or a null reference always returns false.
 */
public class AdditionalOperators {
    public static void main(String[] args) {
        assignmentEqualityOperator();
        relationalOperators();
        instanceOfOperator();
    }

    private static void assignmentEqualityOperator() {
        long wolf = 5;
        //(wolf=3) does two things. First, it sets the value of the variable wolf to be 3. Second, it returns a value of the assignment, which is also 3.
        long coyote = (wolf=3);
        System.out.println(wolf);           // 3

        boolean healthy = false;
        if(healthy = true)
            System.out.print("Good!");

        boolean zebra = true == false;      //as per precedence == then =
        System.out.println(zebra);

        //boolean monkey = true == 3;       // DOES NOT COMPILE
        //boolean ape = false != "Grape";   // DOES NOT COMPILE
        //boolean gorilla = 10.2 == "Koko"; // DOES NOT COMPILE

        boolean bear = false;
        boolean polar = (bear = true);
        System.out.println(polar);          //true
        System.out.print(null == null);     //true
    }

    private static void relationalOperators() {
        int rabbit = 6;
        //the increment operator on the right side of the expression is never evaluated, so the output is 6.
        boolean bunny = (rabbit >= 6) || (++rabbit <= 7);
        System.out.println(rabbit);

        //ternary operator
        int stripes = 7;
        System.out.print((stripes > 5) ? 21 : "Zebra");
        //int animal = (stripes < 9) ? 3 : "Horse";  // DOES NOT COMPILE
    }

    private static void instanceOfOperator() {
        System.out.println(null instanceof Object);         //false
        Object noObjectHere = null;
        System.out.println(noObjectHere instanceof String); //false
        //System.out.print(null instanceof null);           // DOES NOT COMPILE
        openZoo(2);                                    //compiler boxed it to Integer Wrapper
    }

    public static void openZoo(Number time) {
        System.out.println(time.getClass());
        if(time instanceof Integer)
            System.out.print((Integer)time + " O'clock");
        else
            System.out.print(time);

        //if(time instanceof String)                        // DOES NOT COMPILE
    }
}
