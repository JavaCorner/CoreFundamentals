package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * String Concatenation:
 * If both operands are numeric, + means numeric addition.
 * If either operand is a String, + means concatenation.
 * The expression is evaluated left to right.
 *
 * Interning : JVM optimize memory allocated to store String objects by maintaining a single copy of each string literal
 *              in the string pool memory area, regardless of how many variables references to this copy.
 *              intern() method returns a reference to an interned copy of string literal.
 *              using new keyword disables string interning
 */
public class StringDemo {
    public static void main(String[] args) {
        //string concatenation
        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four);

        String s1 = "1";
        String s2 = s1.concat("2");
        s2.concat("3");                                                 //concat returns a string object as string is immutable
        System.out.println(s2);

        //length()
        //charAt(int index)

        //indexOf(String str, int fromIndex)                            //fromIndex is inclusive and optional
        String string = "animals";
        System.out.println(string.indexOf('a'));                        // 0
        System.out.println(string.indexOf("al"));                       // 4
        System.out.println(string.indexOf('a', 4));         // 4
        System.out.println(string.indexOf("al", 5));        // -1

        //substring(int beginIndex, int stopAt)                         //beginIndex is inclusive //stopAt is exclusive and optional
        System.out.println(string.substring(3));                        // mals
        System.out.println(string.substring(string.indexOf('m')));      // mals
        System.out.println(string.substring(3, 4));                     // m
        System.out.println(string.substring(3, 7));                     // mals //notice 7 is not giving index out of bound because its exclusive
        //System.out.println(string.substring(3, 8));                   //throws index out of bound

        //contains() method is a convenience method so you don’t have to write str.indexOf(otherString) != -1.
        System.out.println(string.contains("al"));                      // true

        //trim() - remove whitespace from the beginning and end of a String.whitespace consists of spaces along with the \t (tab), \n (newline), \r (carriage return).
        //Methods added in Java 11 strip(), stripLeading(), and stripTrailing()
        //strip() does everything that trim() does, but it supports Unicode.
        // \u2000 is a unicode whitespace which trim will not remove. this can be verified in console print
        System.out.println("\t   a b c\u2000\n\r".trim());
        System.out.println("\t   a b c\u2000\n\r".strip());

        //method chaining
        String result = "AniMaL   ".trim().toLowerCase().replace('a', 'A');//4 string objects will be created
        System.out.println(result);

        StringBuilder alpha = new StringBuilder();
        for(char current = 'a'; current <= 'z'; current++)
            alpha.append(current);
        System.out.println(alpha);                                      //total 27 string objects will be created

        String s3 = new String("Hello");                         // s3 points to memory in heap
        String s4 = s3.intern();                                        //s4 points in string pool
        String s5 = "Hello";                                            //s5 points in string pool

        System.out.println(s3 == s4);                                   //false
        System.out.println(s3.equals(s4));                              //true

        System.out.println(s4 == s5);                                   //true
        System.out.println(s4.equals(s5));                              //true
    }
}
