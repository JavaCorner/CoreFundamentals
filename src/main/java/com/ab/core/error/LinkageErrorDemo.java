package com.ab.core.error;

/**
 * @author Arpit Bhardwaj
 *
 * java.lang.NoClassDefFoundError
 */
public class LinkageErrorDemo {

    public static class Calculator{
        static int n = 2/0;
    }
    public static void main(String[] args) {
        try{
            new Calculator();   //throws java.lang.ExceptionInInitializerError
        }
        catch (Error e){
            System.out.println(e);
        }
        new Calculator();       //throws java.lang.NoClassDefFoundError
    }
}
