package com.ab.core.exception;

import java.util.Locale;

/**
 * @author Arpit Bhardwaj
 *
 * Throwable <- Exception <- RuntimeException
 *
 * All below exception extends RuntimeException
 *
 * java.lang.ArithmeticException
 * java.lang.ArrayIndexOutOfBoundsException
 * java.lang.ClassCastException
 * java.lang.IllegalArgumentException
 * java.lang.IllegalStateException
 * java.lang.NullPointerException
 *
 * IllegalArgumentException <- NumberFormatException
 * java.lang.NumberFormatException
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
        /*String s1 = null;
        s1.toUpperCase();*/

        //System.out.println(Integer.parseInt("1"));

        //NumberFormatException
        //System.out.println(Integer.parseInt("a"));

        //all dis-joint (non related) are allowed in multi catch
        try {

        }
        catch (NumberFormatException e){
            try {

            }catch (NumberFormatException f){//if use e as veriable then code will not compile

            }
        }catch (ArithmeticException
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
