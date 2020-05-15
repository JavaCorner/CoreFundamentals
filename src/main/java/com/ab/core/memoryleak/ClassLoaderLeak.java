package com.ab.core.memoryleak;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Arpit Bhardwaj
 */
public class ClassLoaderLeak {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String pluginName = "com.ab.core.memoryleak.ExamplePlugin";
        while (true){
            System.out.println("Press any key to load plugin");
            System.in.read();

            URL[] urls = {
                    new File("target/classes").toURI().toURL()
            };
            URLClassLoader classLoader = new URLClassLoader(urls,null);
            Class<?> aClass = classLoader.loadClass(pluginName);
            Object plugin = aClass.newInstance();
        }
    }
}


