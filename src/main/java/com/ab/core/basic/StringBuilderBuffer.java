package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 *  String extends nothing implements CharSequence, Serializable and Comparable
 *  AbstractStringBuilder implements CharSequence, Apendable
 *  StringBuilder extends AbstractStringBuilder implements CharSequence, Serializable
 *  StringBuffer extends AbstractStringBuilder implements CharSequence, Serializable
 *
 *  Objects of String are immutable, and objects of StringBuffer and StringBuilder are mutable.
 * StringBuffer and StringBuilder are similar, but
 * StringBuilder is faster and preferred over StringBuffer for the single-threaded program.
 * If thread safety is needed, then StringBuffer is used.
 *
 */
public class StringBuilderBuffer {
    public static void main(String[] args) {
        String str = "Geeks";
        //convert str to string builder and buffer
        StringBuilder sBuilder = new StringBuilder(str);
        StringBuffer sBuffer = new StringBuffer(str);

        //convert string builder and buffer to string
        sBuilder.toString();
        sBuffer.toString();

        //convert String Buffer to String Builder

    }
}
