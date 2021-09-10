package com.ab.core.controlflow;

/**
 * @author Arpit Bhardwaj
 *
 */
public class InfiniteLoops {
    public static void main(String[] args) {
        //while (true){ }
        //while(true);

        //in for loop all three initialization, condition, modification is optional
        //if above loop is uncomment then unreachable code compiler error will come
        //for (;;) { }
        //for (;;);
        //for (;true;)

        //do {}while(true);

        loop:do {
            System.out.println("Broke the infinite do while");
            break loop;
        }while (true);

        //you cannot make for each infinite in similar way
        //for(:){} //will not compile

        int start = Integer.MAX_VALUE - 1;
        //for (int i = start; i <= start + 1 ; i++) { }

        Integer i = new Integer(0);
        Integer j = new Integer(0);

        while (i <= j && j <= i && i != j){}

    }
}
