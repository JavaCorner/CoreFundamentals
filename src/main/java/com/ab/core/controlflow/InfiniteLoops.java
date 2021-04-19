package com.ab.core.controlflow;

/**
 * @author Arpit Bhardwaj
 *
 */
public class InfiniteLoops {
    public static void main(String[] args) {
        //while (true){ }
        //or
        //while(true);

        //in for loop all three initialization, condition, modification is optional
        //if above loop is uncomment then unreachable code compiler error will come
        //for (;;) { }
        //or
        //for (;;);

        //you cannot make for each infinite in similar way
        //for(:){} //will not compile

        int start = Integer.MAX_VALUE - 1;
        //for (int i = start; i <= start + 1 ; i++) { }

        Integer i = new Integer(0);
        Integer j = new Integer(0);

        while (i <= j && j <= i && i != j){}

    }
}
