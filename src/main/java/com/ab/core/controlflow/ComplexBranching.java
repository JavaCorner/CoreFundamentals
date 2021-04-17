package com.ab.core.controlflow;

/**
 * @author Arpit Bhardwaj
 *
 *
 */
public class ComplexBranching {
    public static void main(String[] args) {
        //by default loops are tied to only statement below it like if/else
        //more than 1 statement required to be wrapped in brackets
        for (int i = 0; i < 1; i++)
            System.out.println("for");

        int i = 1;
        while (i==1)
            i=0;

        do
            System.out.println("do while");
        while (i==1);


        for (int j = 0; j < 1; j++)
            //the below if else block considered as 1 statement hence brackets not required for for loop
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


    }
}
