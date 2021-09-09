package com.ab.core.overloading;

/**
 * @author Arpit Bhardwaj
 *
 * You cannot widen and then box.
 * E.g. test(int) cannot call test(Long) since to call test(Long) the compiler need to convert int to Integer then Integer to Long which is not possible.
 *
 */
public class BreakingBad {

    public static void main(String[] args) {
        BreakingBad bad = new BreakingBad();
        short s = 10;
        //bad.testInteger(s);   //Compile time error. You cannot widen and then box
        bad.testNumber(s);      //first Boxed to Short then Widen to Number
        int i = 10;
        bad.testInteger(i);     //Autoboxed to Integer
        long l = 10;
        bad.testLong(l);        //Autoboxed to Long
    }

    private void testNumber(Number number) {
        System.out.println("Number");
    }

    private void testInteger(Integer integer) {
        System.out.println("Integer");
    }

    private void testLong(Long l) {
        System.out.println("Long");
    }
}
