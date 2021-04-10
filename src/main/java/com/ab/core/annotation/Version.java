package com.ab.core.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Versions.class)
@Inherited
public @interface Version {
    int value();
    String author() default "Arpit Bhardwaj";
    String license() default "MIT";
    String[] environments() default {"development"};
}
