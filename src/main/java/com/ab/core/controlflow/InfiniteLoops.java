package com.ab.core.controlflow;

/**
 * @author Arpit Bhardwaj
 *
 */
public class InfiniteLoops {
    public static void main(String[] args) {
        //while and for exists without body but not doWhile
        //while (true){ }   //compiles (infinite loop)
        //while(true);      //compiles (infinite loop)
        //while(false);     //not compile due to unreachability

        //in for loop all three initialization, condition, modification is optional
        //for (;;) { }      //compiles (infinite loop)
        //for (;;);         //compiles (infinite loop)
        //for (;true;);     //compiles (infinite loop)

        //do {}while(true); //compiles (infinite loop)
        //do while(true);   //not compile

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
