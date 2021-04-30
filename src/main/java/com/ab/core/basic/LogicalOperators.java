package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * Logical operators
 *
 * Operator	Description
 * &	Logical AND is true only if both values are true.
 * |	Inclusive OR is true if at least one of the values is true.
 * ^	Exclusive XOR is true only if one value is true and the other is false.
 *
 * Tip:
 * AND is only true if both operands are true.
 * Inclusive OR is only false if both operands are false.
 * Exclusive OR is only true if the operands are different.
 *
 * Short-circuit operators
 *
 * Operator	Description
 * &&	Short-circuit AND is true only if both values are true. If the left side is false, then the right side will not be evaluated.
 * ||	Short-circuit OR is true if at least one of the values is true. If the left side is true, then the right side will not be evaluated.
 *
 * A more common example of where short-circuit operators are used is checking for null objects before performing an operation.
 */
public class LogicalOperators {
    public static void main(String[] args) {
        int rabbit = 6;
        //the increment operator on the right side of the expression is never evaluated, so the output is 6.
        boolean bunny = (rabbit >= 6) || (++rabbit <= 7);
        System.out.println(rabbit);

        //ternary operator
        int stripes = 7;
        System.out.print((stripes > 5) ? 21 : "Zebra");
        //int animal = (stripes < 9) ? 3 : "Horse";  // DOES NOT COMPIL
    }
}
