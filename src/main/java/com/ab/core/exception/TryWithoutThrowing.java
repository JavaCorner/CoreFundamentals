package com.ab.core.exception;

import java.io.IOException;

/**
 * @author Arpit Bhardwaj
 */
public class TryWithoutThrowing {
    public static void main(String[] args) {
        inValidTest();
        validTest();
        validTest2();
    }

    //It is not allowed to catch a Checked Exception which is not thrown from try block
    private static int inValidTest() {
        /*try {

        } catch (IOException e){

        }*/
        return 0;
    }

    /*compiler doesn't complains because when you catch Unchecked exception
    that is either RuntimeException or Error or any subclass of it then compiler doesn't check what is written in try block
    because this Exception/Error can occur at run time*/

    private static int validTest() {
        try {

        } catch (NullPointerException e){

        }
        return 0;
    }

    /*Compiler doesn't complain because compiler is not sure that catch block is wrote to handle checked exception or unchecked(Runtime) exception
    as Exception class can handle both so above code is perfectly valid.*/

    private static int validTest2() {
        try {

        } catch (Exception e){

        }
        return 0;
    }
}
