package com.ab.core.basic;

//import java.nio.*.*;//compile error
import java.nio.file.Paths.*;// causes Paths declaration to not compile
import java.nio.*;// causes Paths or Files declaration to not compile
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;// causes Date declaration to not compile
import java.sql.*;
import java.util.Date;

import static java.util.Arrays.asList;

/**
 * @author Arpit Bhardwaj
 *
 * 3 Types of comments:
 * Single Line:
 * Multi Line:
 * Javadoc Comment: This comment is similar to a multiline comment except it starts with /**.
 *                  This special syntax tells the Javadoc tool to pay attention to the comment.
 *                  Javadoc comments have a specific structure that the Javadoc tool knows how to read.
 *
 * Multiple Classes in Single File
 * You can put multiple default(package private) classes and a single public class in the same file.
 * In Nutshell
 *   at most one of the classes in the file is allowed to be public.
 *   and the public class needs to match the filename.
 *
Full command	                                Single-file source-code command
javac HelloWorld.java                           java HelloWorld.java
java HelloWorld

Produces a class file	                        Fully in memory
For any program	                                For programs with one file
Can import code in any available Java library	Can only import code that came with the JDK

Imports

1. regular imports are for importing a class
2. static imports are only for importing static members.

You can import a specific class or all classes in a specific package.
Point to note:
It doesn’t import child packages, fields, or methods; it imports only classes.
Listing the classes used makes the code easier to read, especially for new programmers.
Using the wildcard can shorten the import list.
Importing with wildcards doen't slow down your program.The compiler is smart enough figures out what’s actually needed.
There’s one special package in the Java world called java.lang. This package is special in that it is automatically imported.

3 Redundant Imports
import java.lang.System;
import java.lang.*;
import java.util.Random;
import java.util.*;

import java.nio.*;         // Will not work (but there is no compiler error in this line though there is an compiler error on actual usage line as import still not happended) -
a wildcard only matches class names, not "file.Files"

import java.nio.*.*;       // Will not work - you can only have one wildcard and it must be at the end

import java.nio.file.Paths.*; // Will not work - you cannot import methods only class names

Compiling with packages and directories
javac -d classes packagea/ClassA.java packageb/ClassB.java
java -cp classes packageb.ClassB or java -classpath classes packageb.ClassB or java --class-path classes packageb.ClassB

or if you classes or directory elsewhere

java -cp ".;C:\temp\someOtherLocation;c:\temp\myJar.jar" myPackage.MyClass

Create Jar File (. represents current directory)
jar -cvf myNewFile.jar . or jar --create --verbose --file myNewFile.jar .
jar -cvf myNewFile.jar -C <directory>

 */

public class Basic {
    /*
    * // anteater
    */

    // bear

    // // cat

    // /* dog */

    /* elephant */

    /*
     * /* ferret */
    //this will not compile if you uncomment this as this is extra*/

    public void read(Files files) {
        Paths.get("name");
    }

    Date date;

    public static void main(String[] args) {
        //Arrays.asList("one"); // DOES NOT COMPILE if we don't regular import arrays and only do static import of asList
        asList("two"); //this wil compile if we only do static import of asList
    }
}

class test{

}
