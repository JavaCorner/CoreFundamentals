package com.ab.core.reflection;

import java.lang.management.MonitorInfo;
import java.lang.reflect.Modifier;

public class AccessTypeInformation {
    public static void main(String[] args) {
        HighVolumeAccount highVolumeAccount = new HighVolumeAccount("12345");
        classInfo(highVolumeAccount);
        modifiersInfo(highVolumeAccount);
    }

    private static void modifiersInfo(HighVolumeAccount highVolumeAccount) {
        Class<?> theCls = highVolumeAccount.getClass();
        int modifiers = theCls.getModifiers();

        if(Modifier.isFinal(modifiers)){
            System.out.println("Method Check- final");
        }

        if(Modifier.isPrivate(modifiers)){
            System.out.println("Method Check - private");
        }else if (Modifier.isProtected(modifiers)){
            System.out.println("Method Check - private");
        }else if (Modifier.isPublic(modifiers)){
            System.out.println("Method check - public");
        }
    }

    private static void classInfo(HighVolumeAccount highVolumeAccount) {
        Class<?> theCls = highVolumeAccount.getClass();
        System.out.println(theCls.getSimpleName());

        Class<?> theSuperCls = theCls.getSuperclass();
        System.out.println(theSuperCls.getSimpleName());

        Class<?>[] theClsInterfaces = theCls.getInterfaces();
        for (Class<?> itf: theClsInterfaces
             ) {
            System.out.println(itf.getSimpleName());
        }
    }
}
