package com.ab.core.error;

/**
 * @author Arpit Bhardwaj
 *
 * java.lang.StackOverflowError
 */
public class StackoverflowError {
    public static void main(String[] args) {
        calculate(1,2);
    }

    private static void calculate(int i1, int i2) {
        calculate(i1,i2);
    }
}
