package com.ab.core.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Arpit Bhardwaj
 *
 * Path is an interface.
 * A path is created from a file system.
 * Specfic implementation can be created for specific file system
 *
 */

public class PathDemo {
    public static void main(String[] args) {
        Path path0 = Paths.get("debug.log");
        Path path1 = Paths.get("C:/files/debug.log");
        Path path2 = Path.of("data.csv");
        Path path3 = Path.of("/files/data.csv");//absolute
        Path path4 = Path.of("");
        Path path5 = Paths.get("C:/files/data.csv");
        Path path6 = Paths.get("/videos/../..//..//videos");

        System.out.println("Path 1 = " + path1);
        System.out.println("Path 1 = " + path2);
        System.out.println("Path 1 = " + path1.getClass());

        boolean isAbsolutePath1 = path1.isAbsolute();
        boolean isAbsolutePath2 = path2.isAbsolute();
        System.out.println("isAbsolute = " + isAbsolutePath1);
        System.out.println("isAbsolute = " + isAbsolutePath2);

        Path root = path1.getRoot();
        System.out.println("Root = " + root);
        //resolve will be the concatenation path1 and path2
        System.out.println(path1.resolve(path2));
        //path3 is an absolute path then it will simply give path3
        System.out.println(path1.resolve(path3));

        //resolve sibling resolve path against parent
        System.out.println(path1.resolveSibling(path2));
        System.out.println(path1.resolveSibling(path4));

        //if path doesn't have any parent then simply give path
        System.out.println(path0.resolveSibling(path2));

        //relativize is to find the path to take from one path to another
        //for this to work either both should be relative or both should be absolute
        System.out.println(path1.relativize(path5));
        //System.out.println(path1.relativize(path4));

        //normalize simplifies the path
        System.out.println(path6.normalize());
    }
}
