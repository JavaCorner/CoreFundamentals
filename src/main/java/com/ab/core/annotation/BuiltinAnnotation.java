package com.ab.core.annotation;

import com.ab.core.annotation.model.Engineer;
import com.ab.core.annotation.model.Person;

import java.lang.annotation.Annotation;
import java.util.function.Function;

@SuppressWarnings("deprecation")
public class BuiltinAnnotation {
    public static void main(String[] args) {
        Person p = new Engineer(1L,"Arpit Bhardwaj");
        System.out.println(p.details());
        System.out.println(p.detailsV2());

        Annotation[] annotations = p.getClass().getAnnotations();
        System.out.println(annotations.length);

        for (Annotation annotation:
             annotations) {
            if(annotation instanceof Version){
                System.out.println("Found Version annotation on type");
                Version version = (Version) annotation;
                System.out.printf("Version #%d%n", version.value());
            }else if(annotation instanceof Versions){
                System.out.println("Found Versions annotation on type");
                Versions versions = (Versions) annotation;
                for (Version version:
                     versions.value()) {
                    System.out.printf("Version #%d%n", version.value());
                }
            }
        }
        String x = "abc";
        //Function<String, String> func = (@NonNull x) > x.toUpperCase();
    }
}
