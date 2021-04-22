package com.ab.main;
import com.ab.service.HelloMessageService;

import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello from greeter.cli module");

        HelloMessageService messageService = new HelloMessageService();
        System.out.println(messageService.getMessage());

        try {
            Type genericType = Class.forName("com.ab.util.CapitalizeUtil").getDeclaredField("secret").getGenericType();
            System.out.println(genericType.getTypeName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
