package com.ab.core.controlflow;

/**
 * @author Arpit Bhardwaj
 *
 * By default, loops are tied to only statement below it like if/else
 * more than 1 statement required to be wrapped in brackets
 *
 * The break terminates innermost switch or loop
 * The return exit current method and terminates all switches and loops within that method
 */
public class ComplexBranching {
    public static void main(String[] args) {

        //for loop
        for (int i = 0; i < 1; i++)
            System.out.println("for");

        int i = 1;

        //while loop
        while (i==1)
            i=0;

        //do while loop
        do
            System.out.println("do while");
        while (i==1);

        for (int j = 0; j < 1; j++)
            //the below if else block considered as 1 statement hence brackets not required
            if (j!=0)
                System.out.println("for if");
            else
                System.out.println("for else");

            int j = 0;

            if (j==0)
                //the below do while block is considered as 1 statement
                do
                    System.out.println("if do");
                while (j==1);
                    else
                System.out.println("if do while else");

        //while and for exists without body but not doWhile
        // while(true);     //compiles (infinite loop)
        //for (;true;);     //compiles (infinite loop)
        //do while(true);   //not compile

        //while(false);//not compile due to unreachability

        int sum = 0;
        int x = 0;
        for(int k = 0; k < 2; sum += k++)
        for(long y = 0, z = 4; x < 5 && y < 10; x++, y++)
            System.out.print(y + " ");

        //for(long y = 0, int z = 4; x < 5; x++) // DOES NOT COMPILE (only compound initialization works)
            //System.out.print(y + " ");

        int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};

        //A label is an optional pointer to the head of a statement that allows the application flow to jump to it or break from it.
        //Labels follow the same rules for formatting as identifiers.
        OUTER_LOOP:  for(int[] mySimpleArray : myComplexArray) {
            INNER_LOOP:  for(int k=0; i<mySimpleArray.length; k++) {
                //System.out.print(mySimpleArray[k]+"\t");
            }
            System.out.println();
        }

        //it is possible to add optional labels to control and block statements.
        //but its actually of no use, and it's very uncommon
        int frog = 15;
        BAD_IDEA: if(frog>10)
            EVEN_WORSE_IDEA: {
                frog++;
        }
        methodWithLoops();
        printOdd();
    }

    private static void printOdd() {
        for(int i=0; i<5; i++) {
            System.out.println(++i);
        }

        for(int i=0; i<5; ){
            //System.out.println(++i++);
        }

        int i=0;
        while(i<5){
            i++;
            System.out.println(++i);
        }

        /*for(int j=0; ; j++){
            if(j<5)
                continue;
            System.out.println(++j);
        }*/

        int k=0;
        while(k<5){
            System.out.println(++k);
            ++k;
        }
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
