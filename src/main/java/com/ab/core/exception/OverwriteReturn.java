package com.ab.core.exception;

/**
 * @author Arpit Bhardwaj
 *
 * The return statement in the try block will be overwritten by the return statement in finally block.
 */
public class OverwriteReturn {
    public static void main(String[] args) {
        System.out.println("Value of a: " + test());
    }

    private static int test() {
        int a = 10;
        try {
            return a;
        }catch (Exception e){
            a = 20;
            System.out.println("a in catch : " + a);
        }finally {
            a = 30;
            System.out.println("a in finally : " + a);
            //return a;
        }
        //compile error : unreachable code
        //Need to remove return in finally to make to reachable
        a = 40;
        System.out.println("a outside try catch finally : " + a);
        return a;
    }
}
