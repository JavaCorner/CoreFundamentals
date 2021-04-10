package com.ab.core.annotation.model;

public class Person {

    protected Long id;
    protected String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("unused")
    public String greet(){
        return "Hi, I am " + this.name;
    }

    @Deprecated
    public String details(){
        return String.format("[%s] %s", this.id, this.name);
    }

    public String detailsV2(){
        return String.format("[%s] %s", this.id, this.name);
    }
}
