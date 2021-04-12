package com.ab.core.error;

/**
 * @author Arpit Bhardwaj
 *
 * Errors are the conditions which cannot get recovered by any handling techniques
 *
 * Recovering from Error is not possible.
 * All errors in java are unchecked type.
 *
 * Example:
 * java.lang.ExceptionInInitializerError
 * java.lang.StackOverflowError
 * java.lang.OutOfMemoryError
 */
public class ThrowError {
    public static void main(String[] args) {
        try{
            defectedCode();
            System.out.println("A");
        }
        catch(Error e){
            System.out.println("B");
        }
        catch(Exception e){
            System.out.println("C");
        }
        catch(Throwable e){
            System.out.println("D");
        }
        finally{
            System.out.println("E");
        }
        System.out.print("F");
    }

    private static void defectedCode() {
        throw new Error();
    }
}
