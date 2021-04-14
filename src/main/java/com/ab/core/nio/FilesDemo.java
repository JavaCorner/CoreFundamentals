package com.ab.core.nio;

import java.io.File;
import java.io.IOException;

/**
 * @author Arpit Bhardwaj
 *
 * File is a class and it is used to
 *      To create and delete files
 *      create directories
 *      analyze the path
 *      get the real path to a directory
 *
 * Disadvantage : does not know the underlying file system (windows,mac,linux etc).
 *                  for all file system the file class is same
 *
 */
public class FilesDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("files/sonnet-ISO.txt");
        System.out.println("File Exists " + file.exists());
        System.out.println("isDirectory " + file.isDirectory());
        System.out.println("isFile " + file.isFile());

        File newFile = new File("files/sonnet.txt");//this line wil not create a file
        boolean fileCreated = newFile.createNewFile();

        System.out.println("File Created " + fileCreated);

        File dir = new File("files/data");
        boolean dirCreated = dir.mkdir();
        System.out.println("Directory Created " + dirCreated);

        File dirs = new File("files/data2/data3");
        boolean dirsCreated = dirs.mkdirs();
        System.out.println("Directories Created " + dirsCreated);

        boolean fileDeleted = newFile.delete();
        System.out.println("File Deleted " + fileDeleted);
        boolean dirDeleted = dir.delete();
        System.out.println("Directory Deleted " + dirDeleted);
        boolean dirsDeleted = dirs.delete();
        System.out.println("Directories Deleted " + dirsDeleted);

        File dir2 = new File("files/data2");
        dir2.delete();

        File file2 = new File("files/data.csv");
        System.out.println("getName " + file2.getName());
        System.out.println("getParent " + file2.getParent());
        System.out.println("getPath " + file2.getPath());

        System.out.println("getAbsolutePath " + file2.getAbsolutePath());
        System.out.println("getCanonicalPath " + file2.getCanonicalPath());

    }
}
