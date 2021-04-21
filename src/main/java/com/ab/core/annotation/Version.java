package com.ab.core.annotation;

import com.ab.core.lambdastreams.model.Category;

import java.lang.annotation.*;

/**
 * @author Arpit Bhardwaj
 *
 * An annotation element type must be a primitive type, a String, a Class, an enum, another annotation, or an array of any of these types.
 *
 * Marker Annotation
 * @Inherited, @Documented, @Override
 */

@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Versions.class)
@Inherited
public @interface Version {
    int value();
    String author() default "Arpit Bhardwaj";
    String license() default "MIT";
    String[] environments() default {"development"};
    public static final int z = 2;
    class test{};
    //default void test1();//not allowed
    //static void test2();//not allowed
    Category category() default Category.FOOD;
}
