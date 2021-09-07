package com.ab.core.security;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class ImmutablePerson {
    private final String name;//immutable
    private final Date birthday;//mutable
    private final List hobbies;//mutable

    public ImmutablePerson(String name, Date birthday, List hobbies) {
        this.name = name;
        this.birthday = birthday;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return (Date) birthday.clone();
    }

    public List getHobbies() {
        return Collections.unmodifiableList(hobbies);
    }
}
