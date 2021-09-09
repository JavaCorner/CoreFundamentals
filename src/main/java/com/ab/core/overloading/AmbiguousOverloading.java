package com.ab.core.overloading;

/**
 * @author Arpit Bhardwaj
 *
 * If more than one method is both accessible and applicable to a method invocation then java follow below rules
 *
 * Invocation Precedence
 *      Specific Invocation (Inheritance Hirarchy)
 *      Widening
 *      Boxing
 *      varargs
 *
 */
public class AmbiguousOverloading {

    public static void main(String[] args) {
        AmbiguousOverloading overloading = new AmbiguousOverloading();
        overloading.test(null);      //specific String parameter implementation will be called
        //overloading.test(null,null);  //compiler error (Ambiguous method call)
        //overloading.testArray(null);  //compiler error (Ambiguous method call) (int[] and char[] are at same level to Object class and fall in different hierarchy)
    }

    private void test(Object obj) {
        System.out.println("Object implementation");
    }

    private void test(String str) {
        System.out.println("String implementation");
    }

    //StringBuffer and String are in same level
    //private void test(StringBuffer str) { System.out.println("StringBuffer implementation"); }

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
