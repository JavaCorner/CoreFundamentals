package com.ab.core.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Versions {
    Version[] value(); //array of another annotation
}
