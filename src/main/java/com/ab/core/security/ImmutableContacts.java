package com.ab.core.security;

/**
 * @author Arpit Bhardwaj
 *
 * Java class is immutable, because its state can not be changed once created.
 * if all field itself are immutable like this example, its easy to make class immutable
 * its get tricky when the fields are mutable
 *
 */
public final class ImmutableContacts {
    private final String name;
    private final String mobile;

    public ImmutableContacts(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }
}
