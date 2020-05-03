package com.ab.core.customclass;

/**
 * @author Arpit Bhardwaj
 */
public class CustomInteger extends Number implements Comparable<CustomInteger>{

    public static final int   MIN_VALUE = 0x80000000;
    public static final int   MAX_VALUE = 0x7fffffff;

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public int compareTo(CustomInteger o) {
        return 0;
    }
}
