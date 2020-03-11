package com.ab.core.overloading;

/**
 * @author Arpit Bhardwaj
 *
 * Widening of reference variable depends on inheritance tree(so, Integer cannot be widened to Long. But, Integer widened to Number because they are in same inheritance hierarchy).
 * You cannot widen and then box. Eg. test(int) cannot call test(Long) since to call test(Long) the compiler need to convert int to Integer then Integer to Long which is not possible..
 */
public class BreakingBad {

    public static void main(String[] args) {
        BreakingBad bad = new BreakingBad();
        short s = 10;
        //bad.test(s);//Compile time error. It is breaking rule "You cannot widen and then box"
    }

    private void test(Integer integer) {
        System.out.println("Integer");
    }

    private void test(Long l) {
        System.out.println("Long");
    }
}
