package com.ab.core.customclass;

import java.io.Serializable;

/**
 * @author Arpit Bhardwaj
 */
public class CustomString implements CharSequence, Serializable,Comparable<CustomString>{

    private final char[] value;

    public CustomString(char[] value) {
        this.value = value;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public int compareTo(CustomString o) {
        return 0;
    }
}
