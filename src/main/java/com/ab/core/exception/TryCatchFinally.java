package com.ab.core.exception;

/**
 * @author Arpit Bhardwaj
 * Rule:
 * 1. After try block, there can be direct finally block. OR
 * 2. After try block, there can be direct catch block.
 *
 * Note: Only try block without catch or finally is compiletime error.
 */
public class TryCatchFinally {
    public static void main(String[] args) {
        //test1();
        System.out.println("Value of a: " + validTest());   // print a : 20
        System.out.println("Value of a: " + validTest2());  // print a : 30
        System.out.println("Value of a: " + validTest3());  // print a : 50
    }

    private static int validTest() {
        int a = 10;
        try {
            return a;
        }finally {
            a = 20;
            return a;
        }
    }

    private static int validTest2() {
        int a;
        try {
            throw new NullPointerException();
        }catch(Exception e) {
            a = 30;
            return a;
        }
    }

    private static int validTest3() {
        int a;
        try {
            throw new NullPointerException();
        }catch(Exception e) {
            a = 40;
            return a;
        }finally {
            a = 50;
            return a;
        }
    }

    private static void test1(){
        try{
            test2();
        }catch (NullPointerException e){
            System.out.println("Custom NPE");
        }catch (Exception e){
            System.out.println("Custom Exception");
        }
    }
    private static void test2() throws Exception{
        throw new NullPointerException("Custom Null Pointer");
    }
}
