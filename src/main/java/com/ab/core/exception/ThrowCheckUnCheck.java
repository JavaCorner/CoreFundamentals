package com.ab.core.exception;

import java.io.IOException;

/**
 * @author Arpit Bhardwaj
 */
public class ThrowCheckUnCheck {
    public static void main(String[] args) {
        inValidTest();
        inValidTest2();
        validTest();
        validTest2();
        validTest3();
        validTest4();
    }

    /*Exception class is checked exception and when some method throw CHECKED exception,
    then it requires a handler for checked exception or the method itself throws the exception
    claiming as I am not going to handle exception and whoever calls me need to be handled.*/

    private static void inValidTest() {
        //throw new IOException();
    }

    private static void inValidTest2() {
        //throw new Exception();
    }

    private static void validTest() {
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //or

    /*private static void validTest() throws IOException{
        throw new IOException();
    }*/

    /*NullPointerException which is Unchecked exception,
    So it is not mandatory for caller to catch it, If it catches still it is fine, that is why compiler
    doesn't complain for catch block.*/

    private static void validTest2() {
        throw new NullPointerException();
    }

    private static void validTest3() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e){

        }
    }

    private static void validTest4() throws NullPointerException {
        throw new NullPointerException();
    }
}
