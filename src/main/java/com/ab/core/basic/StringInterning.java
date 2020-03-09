package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * When the intern() method is executed then it checks whether the String equals to this String Object is in the pool or not.
 * If it is available, then the string address from the pool is returned. Otherwise, this String object is added to the pool and a reference to this String object is returned.
 *
 * This can be very useful to reduce the memory requirements of your program.
 */
public class StringInterning {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = s1.intern();

        // Comparing memory locations
        // s1 is in Heap
        // s2 is in String Constant Pool
        System.out.println(s1 == s2);
        //content comparison
        System.out.println(s1.equals(s2));

        String s3 = "Hello";
        System.out.println(s2 == s3);
        System.out.println(s1.equals(s2));
    }
}
