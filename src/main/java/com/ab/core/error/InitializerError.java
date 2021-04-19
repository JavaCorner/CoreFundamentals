package com.ab.core.error;

/**
 * @author Arpit Bhardwaj
 *
 * java.lang.ExceptionInInitializerError
 *
 *
 */

public class InitializerError {

    static int n = 2/0;

    public static void main(String[] args) {
        System.out.println("Hello from Main");
    }
}
