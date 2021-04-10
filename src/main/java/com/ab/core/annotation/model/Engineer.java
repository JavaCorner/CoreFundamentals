package com.ab.core.annotation.model;

public class Engineer extends Person{
    public Engineer(Long id, String name) {
        super(id, name);
    }

    @Override
    @SuppressWarnings("deprecation")
    public String details() {
        return String.format("[Engineer #%s] %s", this.id, this.name);
    }

    @Override
    public String detailsV2() {
        return String.format("[Engineer #%s] %s", this.id, this.name);
    }
}
