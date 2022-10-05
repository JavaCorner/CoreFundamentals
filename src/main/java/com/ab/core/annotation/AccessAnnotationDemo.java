package com.ab.core.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Version(value=1)
public class AccessAnnotationDemo {

    public static void main(String[] args) throws Exception {
        for (Annotation annotation : AccessAnnotationDemo.class.getAnnotations()) {
            System.out.println(annotation.getClass().getSimpleName());
            Class<? extends Annotation> type = annotation.annotationType();
            System.out.println("Values of " + type.getName());

            for (Method method : type.getDeclaredMethods()) {
                Object value = method.invoke(annotation, (Object[])null);
                System.out.println(" " + method.getName() + ": " + value);
            }
        }

    }

}
