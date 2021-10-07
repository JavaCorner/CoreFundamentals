package com.ab.core.basic;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * @author Arpit Bhardwaj
 *
 * Class loaders are responsible for loading Java classes during runtime dynamically to the JVM
 * Class loaders can ve built in as well as custom
 * Java classes are loaded by an instance of java.lang.ClassLoader
 *
 * ClassLoader
 *      SecureClassLoader
 *          BuiltinClassLoader
 *              BootClassLoader
 *              PlatformClassLoader
 *              AppClassLoader
 *
 * Built in types:
 *      Bootstrap CL
 *          cl are classes themselves. then who loads the java.lang.ClassLoader itself? Answer is Bootstrap.
 *          it serves as a parent of all the other ClassLoader instances.
 *          it is part of the core JVM and is written in native code.
 *
 *      Extension CL (or Platform CL)
 *          it is a child of the bootstrap cl and takes care of loading the extensions of the standard core Java classes.
 *
 *      System CL
 *           it takes care of loading all the application level classes into the JVM.
 *
 * Let's say we have a request to load an application class into the JVM.
 * The system cl first delegates the loading of that class to its parent platform cl which in turn delegates it to the bootstrap cl.
 * Only  if the bootstrap and then the extension class loader is unsuccessful in loading the class, the system class loader tries to load the class itself.
 *
 * ClassLoader Methods
 *      loadClass() responsible for loading the class
 *          Invokes the findLoadedClass(String) method to see if the class is already loaded.
 *          Invokes the loadClass(String) method on the parent class loader.
 *          Invoke the findClass(String) method to find the class.
 *
 */
public class ClassLoadersDemo {
    public static void main(String[] args) {
        System.out.println("CL for this class " + ClassLoadersDemo.class.getClassLoader()); //System CL
        System.out.println("CL for Math " + Math.class.getClassLoader());                   //Extension CL
        System.out.println("CL for ArrayList " + ArrayList.class.getClassLoader());         //Bootstrap CL
    }
}
