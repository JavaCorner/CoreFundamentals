package com.ab.core.misc;

import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class PropertiesDemo {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("tool", "screwdriver");
        map.put("problem", "knife");

        var props = new Properties();
        map.forEach((k,v) -> props.put(k, v));

        String t = props.getProperty("tool");
        String n = props.getProperty("knife");

        System.out.print(t + " " + n);
    }
}
