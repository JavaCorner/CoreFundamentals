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
 * The order that Java uses to choose the right overloaded method for glide(1,2)
 * Rule	                                what will be chosen for
 * Exact match by type (Specific)	    String glide(int i, int j)
 * Larger primitive type (Widening)	    String glide(long i, long j)
 * Autoboxed type (Boxing)	            String glide(Integer i, Integer j)
 * Varargs	                            String glide(int... nums)
 *
 *  Widening wins over boxing e.g. test(10) will call test(long) instead of test(Integer) if both are available.
 *  Widening wins over var-args e.g. test(byte,byte) will call test(int,int) instead of test(byte...x) method.
 *  Boxing beats var-args e.g. test(byte,byte) will call test(Byte,Byte) instead of test(byte...x) method.
 */
public class AmbiguousOverloading {

    public static void main(String[] args) {
        AmbiguousOverloading overloading = new AmbiguousOverloading();
        overloading.test(null);     //specific String parameter implementation will be called
        //overloading.test(null,null);  //compiler error (Ambiguous method call)
        //overloading.testArray(null);  //compiler error (Ambiguous method call) (int[] and char[] are at same level to Object class and fall in different hierarchy)

        overloading.test1(1);           //Widen to long
        overloading.test2('x');         //Widen to int
        overloading.test2(97);          //specific int
        overloading.test2('x','y');//specific varargs
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

    private void test1(long l) {
        System.out.println("long");
    }

    private void test1(Integer integer) {
        System.out.println("Integer");
    }

    private void test2(int i) {System.out.println("int");}

    private void test2(char... chars) {
        System.out.println("var chars");
    }

}
