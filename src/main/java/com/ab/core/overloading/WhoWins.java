package com.ab.core.overloading;

/**
 * @author Arpit Bhardwaj
 *
 *  Widening wins over boxing e.g. test(10) will call test(long) instead of test(Integer) if both are available.
 *  Widening wins over var-args e.g. test(byte,byte) will call test(int,int) instead of test(byte...x) method.
 *  Boxing beats var-args e.g. test(byte,byte) will call test(Byte,Byte) instead of test(byte...x) method.
 *
 */
public class WhoWins {
    public static void main(String[] args) {
        WhoWins whoWins = new WhoWins();
        whoWins.test(1);//Widen to long
        whoWins.test2('x');//Widen to int
        whoWins.test2(97);//specific int
        whoWins.test2('x','y');//specific varargs
    }

    private void test(long l) {
        System.out.println("long");
    }

    private void test(Integer integer) {
        System.out.println("Integer");
    }

    private void test2(int i) {
        System.out.println("int");
    }

    private void test2(char... chars) {
        System.out.println("var chars");
    }


}
