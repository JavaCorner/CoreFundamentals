package com.ab.core.overloading;

/**
 * @author Arpit Bhardwaj
 *
 * If more than one method is both accessible and applicable to a method invocation then
 * Java compiler uses the set of rules that the most specific method is chosen for invocation.
 *
 * Other Rules:
 * Widening wins over boxing eg. test(10) will call test(long) instead of test(Integer) if both are available.
 * Widening wins over var-args eg test(byte,byte) will call test(int,int) instead of test(byte...x) method.
 * Boxing beats var-args eg test(byte,byte) will call test(Byte,Byte) instead of test(byte...x) method.
 * You cannot widen and then box.
 * You can box and then widen.
 */
public class AmbiguousOverloading {

    public static void main(String[] args) {
        AmbiguousOverloading overloading = new AmbiguousOverloading();
        overloading.test(null);
        //overloading.test(null,null);//compiler error
        //overloading.testArray(null);//compiler error So both the classes int[] and char[] are at same level to Object class and fall in different hierarchy,
    }

    private void test(Object obj) {
        System.out.println("Object implementation");
    }

    private void test(String str) {
        System.out.println("String implementation");
    }

    //Error:(13, 20) java: reference to test is ambiguous
    //StringBuffer and String are in same level
    /*private void test(StringBuffer str) {
        System.out.println("StringBuffer implementation");
    }*/

    private void test(Object obj,String str) {
        System.out.println("Multiple 1 implementation");
    }

    private void test(String str, Object obj) {
        System.out.println("Multiple 2 implementation");
    }

    private void testArray(int[] ints) {
        System.out.println("Int Array implementation");
    }

    private void testArray(char[] chars) {
        System.out.println("Char Array implementation");
    }

}
