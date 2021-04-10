package com.ab.core.annotation;

import com.ab.core.annotation.model.Engineer;
import com.ab.core.annotation.model.Person;

@SuppressWarnings("deprecation")
public class BuiltinAnnotation {
    public static void main(String[] args) {
        Person p = new Engineer(1L,"Arpit Bhardwaj");
        System.out.println(p.details());
        System.out.println(p.detailsV2());
    }
}
