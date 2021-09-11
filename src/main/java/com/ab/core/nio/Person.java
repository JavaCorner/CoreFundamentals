package com.ab.core.nio;

import java.io.Serializable;

/**
 * @author Arpit Bhardwaj
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -1894419180813272900L;

    private String name2;
    private int age;
    private String city;
    private transient int aadharNo;



    public Person(String name, int age, String city) {
        this.name2 = name;
        this.age = age;
        this.city = city;
    }

    public Person(String name, int age, String city, int aadharNo) {
        this(name,age,city);
        this.aadharNo = aadharNo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name2 + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
