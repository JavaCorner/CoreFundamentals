package com.ab.core.annotation;

import com.ab.core.lambdastreams.Category;

import java.lang.annotation.*;

/**
 * @author Arpit Bhardwaj
 *
 * Annotation can have below attributes
 *      primitive type
 *      String
 *      Class
 *      enum
 *      another annotation
 *      An array of the above.
 *
 * Different Retention Levels
 *      SOURCE :    is retained in the source code by discarded by the compiler
 *      CLASS :     is retained by the compiler but ignored by the JVM
 *      RUNTIME :   is reatined by JVM and readble at runtime
 *
 * Different Target Type -> An annotation can be applied to all of these Java declarations.
 *      ANNOTATION_TYPE
 *      CONSTRUCTOR
 *      FIELD
 *      LOCAL_VARIABLE
 *      METHOD
 *      MODULE
 *      PACKAGE
 *      PARAMETER
 *      TYPE
 *      TYPE_PARAMETER
 *      TPE_USE
 *
 * Annotation used to annotate annotation
 *      @Target
 *      @Retention
 *      @Repeatable
 *      @Inherited - Marker Annotation - allows annotations from a superclass to be applied to a subclass
 *      @Documented
 * Marker Annotation
 *      @Documented : Class documentation would include a reference to annotations that are marked as documented
 *      The annotation that validates design
 *          @Override :
 *          @FunctionalInterface
 *          @Cloneable
 *          @Serializable
 * Other Annotations
 *      @Deprecated
 *      @SuppressWarnings
 *      @SafeVarargs
 */

@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Versions.class)
@Inherited
public @interface Version {
    int value();                                                    //primitive
    String author() default "Arpit Bhardwaj";                       //string
    class test{};                                                   //class
    Category category() default Category.FOOD;                      //enum
    String[] environments() default {"development","production"};   //array of Strings
    String license() default z;
    String  z = "MIT";                                              //constants allowed (interface fields are by default constant)

    //default void test1();                                         //not allowed
    //static void test2();                                          //not allowed
    //private void test3();                                         //not allowed

    //a class can implement a annotation
    class test2 implements Versions{

        @Override
        public Version[] value() {
            return new Version[0];
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return null;
        }
    }
}
