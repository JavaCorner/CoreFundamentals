package com.ab.core.annotation.model;

import com.ab.core.annotation.Version;

@Version(1)
@Version(2)
public class Person {

    protected Long id;
    protected String name;

    @Version(1)
    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Version(1)
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
