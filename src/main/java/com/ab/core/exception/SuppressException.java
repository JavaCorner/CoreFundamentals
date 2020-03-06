package com.ab.core.exception;

/**
 * @author Arpit Bhardwaj
 */
public class SuppressException {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static String test() {
        try {
            String str = null;
            return str.toString();
        }finally {
            return "return from finally";
        }
    }
}
