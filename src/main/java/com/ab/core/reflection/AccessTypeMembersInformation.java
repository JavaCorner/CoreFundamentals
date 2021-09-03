package com.ab.core.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccessTypeMembersInformation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234");
        //fieldsInfo(account);
        HighVolumeAccount highVolumeAccount = new HighVolumeAccount("12345");
        methodsInfo(highVolumeAccount);
    }

    private static void methodsInfo(HighVolumeAccount highVolumeAccount) {
        Class<?> theClass = highVolumeAccount.getClass();
        //methods declared in the type class as well as inherited ones but only public
        Method[] theClassMethods = theClass.getMethods();
        //displayMethods(theClassMethods);

        Method[] theClassDeclaredMethods = theClass.getDeclaredMethods();
        displayMethods(theClassDeclaredMethods, highVolumeAccount);
    }

    private static void displayMethods(Method[] theClassMethods, HighVolumeAccount highVolumeAccount) {
        for (Method method:theClassMethods
             ) {
            System.out.println(method.getName() + " : " + method.getReturnType());
            Method declaredMethod = null;
            try {
                //calling a private method of another class
                declaredMethod = HighVolumeAccount.class.getDeclaredMethod(method.getName());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(highVolumeAccount);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    private static void fieldsInfo(BankAccount account) {
        Class<?> theClass = account.getClass();
        //fields declared in the type class as well as inherited ones but only public
        Field[] theClassFields = theClass.getFields();
        displayFields(theClassFields);
        //fields declared in the type class public, protected, private etc
        Field[] theClassDeclaredFields = theClass.getDeclaredFields();
        displayFields(theClassDeclaredFields);
    }

    private static void displayFields(Field[] theClassFields) {
        for (Field field:theClassFields) {
            System.out.println(field.getName() + " : " + field.getType());
        }
    }
}
