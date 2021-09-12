package com.ab.core.nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Arpit Bhardwaj
 *
 * Path is an interface, and it represents files and folders as immutable objects
 * Specfic implementation can be created for specific file system
 *
 * current: represented by .
 * parent: everything before the last /. represented by ..
 * root: may not exist. File system dependent
 * absolute: identififed by file system
 *
 * A path with a absolute may not be absolute.
 *
 */

public class PathDemo {
    public static void main(String[] args) {
        /*
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
        */

        Path someFile = Path.of("/","users","joe","docs","some.txt");

        Path justSomeFile = someFile.getFileName();
        System.out.println(justSomeFile);       //some.txt

        Path docsFolder = someFile.getParent();
        System.out.println(docsFolder);         //\\users\joe\docs

        Path currentFolder = Path.of(".");
        System.out.println(currentFolder);      //.

        /*
        this.resolve(other)
            if other is
                "" -> returns this
                absolute -> other
                root path -> undefined
            else
                concatenated this with other
         */
        Path acmeFile = docsFolder.resolve("../pics/acme.jpg");
        System.out.println(acmeFile);           //\\users\joe\docs\..\pics\acme.jpg

        /*
        this.resolveSibling(other)
            if other is
                "" -> returns parent of this. if this does not have parent then return "".
                absolute -> other
                root path -> undefined
            else
                concatenated parent of this with other
         */
        Path otherFile = someFile.resolveSibling("others.txt");
        System.out.println(otherFile);          //\\users\joe\docs\others.txt

        /*
        this.normalize()
            implementation dependant
            removes redundancies (. and ..)
         */
        Path normalizeAcmeFile = acmeFile.normalize();
        System.out.println(normalizeAcmeFile);  //\\users\joe\pics\acme.jpg

        /*
        this.toRealPath()
            implementation dependant
            creates n absolute path with no links
         */
        try {
            Path verifiedPath = acmeFile.toRealPath();
            System.out.println(verifiedPath);
        } catch (IOException e) {
            System.out.println("Exception Occurred");
        }

        /*
        this.relativize(other)
            if both this and other have a root and none have a root.
                build a relative path from this to other
            if this or other does not have parent
                throws an exception
         */
        Path betweenSomeAndAcme = someFile.relativize(acmeFile);
        System.out.println(betweenSomeAndAcme);//..\..\pics\acme.jpg

        Path users = Paths.get("/", "users");
    }
}
