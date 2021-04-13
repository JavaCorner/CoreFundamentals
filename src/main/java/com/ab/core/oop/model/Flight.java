package com.ab.core.oop.model;

import java.util.UUID;
/**
 * @author Arpit Bhardwaj
 */
public class Flight {
    String id;
    String name;

    static {
        System.out.println("Flight Static Block 1");
    }

    {
        System.out.println("Flight IIB 1");
    }

    private Flight() {
        //IIB code if any got run at this point
        System.out.println("Flight()");
        this.id = UUID.randomUUID().toString();
    }

    public Flight(String name) {
        //IIB code if any got run at this point
        this();
        System.out.println(String.format("Flight(%s)",name));
        this.name = name;
    }
}
