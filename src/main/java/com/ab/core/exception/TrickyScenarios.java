package com.ab.core.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Arpit Bhardwaj
 *
 * Curly Braces are must for all try, catch, finally in all cases.
 *
 * Rule:
 * 1. After try block, there can be direct finally block. OR
 * 2. After try block, there can be direct catch block.
 *
 * Note: Only try block without catch or finally is compiletime error.
 */
public class TrickyScenarios {
    public static void main(String[] args) {
        System.out.println("Value of a: " + validTest0());  // a : 10
        System.out.println("Value of a: " + validTest());   // a : 20
        System.out.println("Value of a: " + validTest2());  // a : 30
        System.out.println("Value of a: " + validTest3());  // a : 50
        System.out.println(suppressException());
        wrapExceptions();
        test1();
    }

    private static int validTest0() {
        int a = 10;
        try {
            return a;
        }finally {
            a = 20;
        }
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

    private static String suppressException() {
        try {
            String str = null;
            return str.toString();
        }finally {
            return "return from finally";
        }
    }

    private static void wrapExceptions() {
        try {
            doThings();
        } catch (NameNotFoundException e) {
            System.out.println(e.getMessage());     //prints the outer exception message
            Throwable cause = e.getCause();
            System.out.println(cause.getMessage()); //prints the inner(wrapped) exception message
        }
    }

    private static void doThings() throws NameNotFoundException {
        try(Reader in = new FileReader("some.txt")){
            char[] buffer = new char[1024];
            in.read(buffer);
        } catch (FileNotFoundException e) {
            //wrap FileNotFoundException in custom NameNotFoundException
            throw new NameNotFoundException("Failed to find the file", e);
        } catch (IOException e) {
            //wrap IOException in custom NameNotFoundException
            throw new NameNotFoundException("Failed to read text", e);
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
