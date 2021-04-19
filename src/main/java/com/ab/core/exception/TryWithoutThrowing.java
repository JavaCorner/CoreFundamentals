package com.ab.core.exception;

import java.io.IOException;

/**
 * @author Arpit Bhardwaj
 */
public class TryWithoutThrowing {
    public static void main(String[] args) {
        invalidTest1();
        invalidTest2();
        validTest1();
        try {
            validTest2();
        } catch (IOException e) {
            e.printStackTrace();
        }
        validTest3();
        validTest4();
        validTest5();

        invalidTest3();
        try {
            validTest6();
        } catch (IOException e) {
            e.printStackTrace();
        }
        validTest7();
        validTest8();
        validTest9();
    }

        /*Exception class is checked exception and when some method throw CHECKED exception,
    then it requires a handler for checked exception or the method itself throws the exception
    claiming as I am not going to handle exception and whoever calls me need to be handled.*/

    private static void invalidTest1() {
        //throw new IOException();
    }

    private static void invalidTest2() {
        //throw new Exception();
    }

    private static void validTest1() {
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //or

    private static void validTest2() throws IOException{throw new IOException();}

    /*NullPointerException which is Unchecked exception,
    So it is not mandatory for caller to catch it, If it catches still it is fine, that is why compiler
    doesn't complain for catch block.*/

    private static void validTest3() {throw new NullPointerException();}

    private static void validTest4() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e){

        }
    }

    private static void validTest5() throws NullPointerException {}

    //It is not allowed to catch a Checked Exception which is not thrown from try block
    private static int invalidTest3() {
        /*try {

        } catch (IOException e){

        }*/
        return 0;
    }

    //It is allowed to throw a Checked Exception using throws clause (as compiler respects unreachable code)
    private static int validTest6() throws IOException{return 0;}

    /*compiler doesn't complains because when you catch Unchecked exception
    that is either RuntimeException or Error or any subclass of it then compiler doesn't check what is written in try block
    because this Exception/Error can occur at run time*/

    private static int validTest7() {
        try {

        } catch (NullPointerException e){

        }
        return 0;
    }

    //It is allowed to throw a unchecked Exception using throws clause
    private static int validTest8() throws NullPointerException{return 0;}

    /*Compiler doesn't complain because compiler is not sure that catch block is wrote to handle checked exception or unchecked(Runtime) exception
    as Exception class can handle both so above code is perfectly valid.*/

    private static int validTest9() {
        try {

        } catch (Exception e){

        }
        return 0;
    }

    private static Exception validTest10(){
        return new Exception();
    }
}
