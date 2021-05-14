package com.ab.core.overriding;

/**
 * @author Arpit Bhardwaj
 *
 * Overriding method in Child class can either have same access specifier as that of Parent class method
 * or can increase visibility but cannot decrease it.
 */
public class AccessSpecifier {
    class A{
        protected void connect(){};
    }
    class B extends A{
        @Override
        public void connect() {}
    }
    public static void main(String[] args) {}
}