package com.ab.core.overloading;

import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * Everything other than the method name can vary for overloading methods.
 * This means there can be different access modifiers, specifiers (like static), return types, and exception lists
 * but above all are irrelevant and raise compile error if done standalone to overload
 * Hence all above change will be effective if done along with parameter list
 *
 * The order that Java uses to choose the right overloaded method for glide(1,2)
 * Rule	                                what will be chosen for
 * Exact match by type (Specific)	    String glide(int i, int j)
 * Larger primitive type (Widening)	    String glide(long i, long j)
 * Autoboxed type (Boxing)	            String glide(Integer i, Integer j)
 * Varargs	                            String glide(int... nums)
 *
 */

public class OverloadingDemo {

    public void fly(int numMiles) {}
    //public int fly(int numMiles) {}               // DOES NOT COMPILE (only return type change)
    //public static void fly(int numMiles) {}       // DOES NOT COMPILE (only specifier change)
    //private static void fly(int numMiles) {}       // DOES NOT COMPILE (only access modifier change)
    public void fly(short numFeet) {}
    public boolean fly() { return false; }
    void fly(int numMiles, short numFeet) {}
    public void fly(short numFeet, int numMiles) throws Exception {}

    //Java treats varargs as if they were an array.the method signature is the same for both methods below.
    public void fly(int[] lengths) {}
    //public void fly(int... lengths) {}            // DOES NOT COMPILE

    //Java has a concept called type erasure where generics are used only at compile time.
    public void walk(List<String> strings) {}
    //public void walk(List<Integer> integers) {}   // DOES NOT COMPILE

    public static void walk(int[] ints) {}
    public static void walk(Integer[] integers) {}

    public static void main(String[] args) {
        OverloadingDemo o = new OverloadingDemo();
        o.fly(new int[] { 1, 2, 3 });       //this will call both array and var args version
        //o.fly(1, 2, 3);                   //this will call only var args version
    }
}
