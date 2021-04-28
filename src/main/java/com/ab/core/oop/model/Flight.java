package com.ab.core.oop.model;

import java.util.UUID;
/**
 * @author Arpit Bhardwaj
 *
 * Order of execution:
 * Parent Static Fields and Static initializer blocks are run in the order in which they appear in the file.
 * Child Static Fields and Static initializer blocks are run in the order in which they appear in the file.
 *
 * Parent Instance Fields and instance initializer blocks are run in the order in which they appear in the file.
 * Parent constructor runs after all fields and instance initializer blocks have run.
 *
 * Child Instance Fields and instance initializer blocks are run in the order in which they appear in the file.
 * Child constructor runs after all fields and instance initializer blocks have run.
 *
 * Point to note: You can’t refer(use) to a variable (static or instance) before it has been defined in initializer blocker though you can refer(use) in contructor
 */
public class Flight {
    String id;
    String name;
    String test1;
    static String test3;

    static {
        System.out.println("Flight Static Block 1");
    }

    {
        test1 = "test1";
        test2 = "test2";
        System.out.println("Flight IIB 1");
        System.out.println("test1 " + test1);
        //System.out.println("test2" + test2);//compile error illegal forward reference
    }

    static {
        test3 = "test3";
        test4 = "test4";
        System.out.println("Flight Static Block 2");
        System.out.println("static test3 " + test3);
        //System.out.println("static test4" + test4);//compile error illegal forward reference
    }

    private Flight() {
        System.out.println("Flight()");
        this.id = UUID.randomUUID().toString();
        System.out.println("test1 " + test1);
        System.out.println("test2 " + test2);// here its allowed as this code will be called after fields has been called.
        System.out.println("static test3 " + test3);
        System.out.println("static test4 " + test4);
    }



    public Flight(String name) {
        this();
        System.out.println(String.format("Flight(%s)",name));
        this.name = name;
    }

    {
        System.out.println("Flight IIB 2");
    }

    String test2;
    static String test4;
}
