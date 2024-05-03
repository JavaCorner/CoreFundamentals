package com.ab.core.exception;

import java.util.Locale;

/**
 * @author Arpit Bhardwaj
 *
 * Unchecked exceptions are often an evidence of a bug in your code, which should be fixed rather than caught
 *
 * Throwable
 *      Exception
 *          RuntimeException
 *              NullPointerException
 *              ArithmeticException
 *              IndexOutOfBoundsException
 *                  ArrayIndexOutOfBoundsException
 *              ClassCastException
 *              IllegalArgumentException
 *                  NumberFormatException
 *              IllegalStateException
 *
 */
public class UncheckedException {
    public static void main(String[] args) {
        //ArithmeticException
        //int result = 5/0;

        //ArrayIndexOutOfBoundsException
        /*int arr[] = new int[1];
        System.out.println(arr[1]);*/

        //compile error
        /*String s = "1";
        Integer n = (Integer) s;*/

        //ClassCastException
        /*String s = "1";
        Object obj = s;
        Integer n = (Integer) obj;*/

        //IllegalArgumentException
        /*int age = 2;
        if(age < 5){
            throw new IllegalArgumentException("message");
        }*/

        //IllegalStateException
        /*boolean isSwitchedOn = true;
        if(isSwitchedOn){
            throw new IllegalStateException("message");
        }*/

        //NullPointerException
        try{
            String s1 = null;
            s1.toUpperCase();
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }

        //NumberFormatException
        try {
            System.out.println(Integer.parseInt("a"));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            try {
            }catch (NumberFormatException f){//if you use e as variable then code will not compile
            }
        }
        //all dis-joint (non related) are allowed in multi catch
        catch (ArithmeticException
                | ArrayIndexOutOfBoundsException
                | ClassCastException
                | IllegalArgumentException
                | IllegalStateException
                | NullPointerException e){
        }
        catch (RuntimeException e){
        }catch (Exception e){
        }catch (Throwable e){
        }
    }
}
