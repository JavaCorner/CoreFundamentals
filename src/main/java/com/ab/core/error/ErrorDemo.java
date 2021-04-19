package com.ab.core.error;

/**
 * @author Arpit Bhardwaj
 *
 * Errors are unchecked exceptions
 * Throwable <- Error
 *
 * java.lang.LinkageError(abstract)
 * java.lang.ExceptionInInitializerError,java.lang.NoClassDefFoundError
 *
 * java.lang.VirtualMachineError(abstract)
 * java.lang.StackOverflowError,java.lang.OutOfMemoryError
 *
 * You can throw, throws and catch Errors
 *
 * Classes listed in the throw and throws part of a method declaration must extend java.lang.Throwable.
 * This includes Error, Exception, and RuntimeException. Arbitrary classes such as String can’t be declared in a throw and throws clause,
 */
public class ErrorDemo {
    public static void main(String[] args) throws ExceptionInInitializerError,StackOverflowError{
        try {
            throw new java.lang.NoClassDefFoundError();
        }catch (ExceptionInInitializerError
                | java.lang.NoClassDefFoundError
                | StackOverflowError
                | OutOfMemoryError e){

        }catch (Error e){

        }catch (Throwable e){

        }
    }
}
