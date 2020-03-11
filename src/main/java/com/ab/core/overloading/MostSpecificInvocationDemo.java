package com.ab.core.overloading;

/**
 * @author Arpit Bhardwaj
 */
public class MostSpecificInvocationDemo {
    class A{};
    class B extends A{};
    class C extends B{};

    public static void main(String[] args) {
        MostSpecificInvocationDemo obj = new MostSpecificInvocationDemo();
        obj.test(null);
    }

    private void test(A obj) {
        System.out.println("A");
    }

    private void test(B obj) {
        System.out.println("B");
    }

    private void test(C obj) {
        System.out.println("C");
    }
}
