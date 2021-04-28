package com.ab.core.gc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Arpit Bhardwaj
 */
public class SawTooth {

    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 32000; i++) {
            Object mine = new GCMe();
            long address = addressOf(mine);
            System.out.println(address);
        }
    }

    private static long addressOf(Object o) {
        Object[] objArr = new Object[]{o};

        return 0;
    }

    private static class GCMe {
        long data;
        long a;
        long aa;
        long aaa;
        long aaaa;
        long aaaaa;
        long aaaaaa;
        long aaaaaaa;
    }

}
