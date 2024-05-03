package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 *
 * Operator	Symbols                     examples
 * Post-unary operators	                expression++, expression--
 * Pre-unary operators	                ++expression, --expression
 * Other unary operators	            -, !, ~, +, (type)
 * Multiplication/division/modulus	    *, /, %
 * Addition/subtraction	                +, -
 * Shift operators	                    <<, >>, >>>
 * Relational operators	                <, >, <=, >=, instanceof
 * Equal to/not equal to	            ==, !=
 * Logical operators	                &, ^, |
 * Short-circuit logical operators	    &&, ||
 * Ternary operators	                boolean expression ? expression1 : expression2
 * Assignment operators	                =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
 *
 * Post-Pre-OtherUnary-Mathematical-shift-relational-equality-logical-shortcircuit-ternany-assignments
 *
 * Numeric Promotion Rules
 * Smaller data types such as byte, short, char are first promoted to int any time they’re used with a Java binary arithmetic operator, even if neither of the operands is int.
 * If two values have different data types, Java will automatically promote one of the values to the larger of the two data types.
 *      ex. If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point value’s data type.
 * After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands.
 *
 */

public class Operators {
    public static void main(String[] args) {

        int x = 1;
        long y = 33;
        var z = x * y;              //the int value is promoted to a long, and the resulting value is long

        long goat = 10;
        int sheep = 5;
        //sheep = sheep * goat;     // DOES NOT COMPILE
        //compound assignment operator save us from casting which they do internally
        sheep *= goat;

        double x1 = 39.21;
        double y1 = 34.21;
        var z1 = x1 + y1;

        short x2 = 10;
        short y2 = 3;
        var z2 = x2 * y2;           // both be promoted to int before the binary multiplication operation, resulting in an output of type int

        short mouse = 10;
        short hamster = 3;
        //short capybara = mouse * hamster;  // DOES NOT COMPILE
        short capybara = (short) (mouse * hamster);


        //First, w will automatically be promoted to int solely because it is a short, and it is being used in an arithmetic binary operation.
        //The promoted w value will then be automatically promoted to a float so that it can be multiplied with x3.
        //The result of w * x3 will then be automatically promoted to a double so that it can be divided by y, resulting in a double value
        short w = 14;
        float x3 = 13;
        double y3 = 30;
        var z3 = w * x3 / y3;

    }
}
