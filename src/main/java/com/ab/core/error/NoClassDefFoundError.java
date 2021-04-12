package com.ab.core.error;

/**
 * @author Arpit Bhardwaj
 *
 * java.lang.NoClassDefFoundError
 */
public class NoClassDefFoundError {

    public static class Calculator{
        static int n = 2/0;
    }
    public static void main(String[] args) {
        try{
            new Calculator();
        }
        catch (Error e){
            System.out.println(e);
        }
        new Calculator();
    }
}
