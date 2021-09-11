package com.ab.core.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Arpit Bhardwaj
 *
 * File is a class, and it is used for below purpose
 *      create and delete files
 *      copy and move files
 *      create directories
 *      analyze the path
 *      get the real path to a directory
 *
 * Disadvantage : does not know the underlying file system (windows,mac,linux etc).
 *                for all file system the file class is same.
 *                To bridge this gap and in order to features of each type and file system, Path interface has been created
 *
 */
public class FilesDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("files/sonnet-ISO.txt");
        System.out.println("File Exists " + file.exists());
        System.out.println("isDirectory " + file.isDirectory());
        System.out.println("isFile " + file.isFile());

        File newFile = new File("files/sonnet.txt");//this line wil not create a file
        System.out.println("File Created " + newFile.createNewFile());

        File dir = new File("files/data");
        System.out.println("Directory Created " + dir.mkdir());

        File dirs = new File("files/data2/data3");
        System.out.println("Directories Created " + dirs.mkdirs());

        System.out.println("File Deleted " + newFile.delete());
        System.out.println("Deleted data dir " + dir.delete());
        System.out.println("Deleted data3 dir " + dirs.delete());

        File dir2 = new File("files/data2");
        System.out.println("Deleted data3 dir " + dir2.delete());

        File file2 = new File("files/data.csv");
        System.out.println("getName " + file2.getName());
        System.out.println("getParent " + file2.getParent());
        System.out.println("getPath " + file2.getPath());

        System.out.println("getAbsolutePath " + file2.getAbsolutePath());
        System.out.println("getCanonicalPath " + file2.getCanonicalPath());

        Path joe = Path.of("/","users","joe");
        Path p1 = Path.of("/","users","joe","docs","some.txt");
        Path p2 = Path.of("./pics/s.txt");
        Files.createSymbolicLink(p2,p1);
        Files.list(joe).forEach(System.out::println);//lists shallow folder content
        Files.walk(joe).map(p-> p.toString())//list deep folder content
                .filter(s -> s.endsWith("txt"))
                .forEach(System.out::println);
        Path path = Files.readSymbolicLink(p2);

    }
}
