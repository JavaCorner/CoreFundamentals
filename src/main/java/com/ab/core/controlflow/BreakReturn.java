package com.ab.core.controlflow;

/**
 * @author Arpit Bhardwaj
 *
 * The break terminates innermost switch or loop
 * The return exit current method and terminates all switches and loops within that method
 */
public class BreakReturn {
    public static void main(String[] args) {
        System.out.println("Before call");
        methodWithLoops();
        System.out.println("After call");
    }

    private static void methodWithLoops() {
        for (int i = 1; i < 4; i++) {
            System.out.println(i);
            for (int j = 0; j < 5; j++) {
                System.out.println(j);
                return;
            }
        }
    }
}
