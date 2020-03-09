package com.ab.core.basic;

import java.text.SimpleDateFormat;

/**
 * @author Arpit Bhardwaj
 *
 * The java.lang.System.identityHashCode() is the method which is used to return the same hash code for any given object
 * that is returned by the default method hashCode()
 *
 *  if a class does not override hashCode(), then its own hash code will obviously match that provided by Object.
 */
public class IdentityHashCodeDemo {
    static class SimpleData{
        private String str;

        public SimpleData(String str) {
            this.str = str;
        }
    }
    public static final String NEWLINE = System.lineSeparator();
    public static void main(String[] args) {
        final Integer int1 = 1;
        final int int2 = 2;
        final Long long1 = 1L;
        final long long2 = 1L;
        final String str = "Hello";
        final String nullStr = null;
        final SimpleData simpleData = new SimpleData("Hello");
        printHashCodes(int1);
        printHashCodes(int2);
        printHashCodes(long1);
        printHashCodes(long2);
        printHashCodes(str);
        printHashCodes(nullStr);
        printHashCodes(simpleData);
    }

    private static void printHashCodes(final Object object) {
        System.out.println("==== "
                + String.valueOf(object)
                +" / "
                + (object != null?object.getClass().getName(): null)
                + " ====");
        System.out.println("Overridden Hashcode : "
                +(object != null? object.hashCode():"NA"));
        System.out.println("Identity Hashcode : " + System.identityHashCode(object));
        System.out.println(NEWLINE);
    }
}
