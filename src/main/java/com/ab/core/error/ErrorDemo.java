package com.ab.core.error;

/**
 * @author Arpit Bhardwaj
 *
 * Errors are the conditions which cannot get recovered by any handling techniques
 *
 * Recovering from Error is not possible.
 * All errors in java are unchecked type.
 *
 * Throwable
 *      Error
 *          LinkageError(abstract)
 *              ExceptionInInitializerError
 *              NoClassDefFoundError
 *          VirtualMachineError(abstract)
 *              StackOverflowError
 *              OutOfMemoryError
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

        try{
            defectedCode();
            System.out.print("A");
        }
        catch(Error e){
            System.out.print("B");
        }
        catch(Exception e){
            System.out.print("C");
        }
        catch(Throwable e){
            System.out.print("D");
        }
        finally{
            System.out.print("E");
        }
        System.out.print("F");
    }

    private static void defectedCode() {
        throw new Error();
    }
}
