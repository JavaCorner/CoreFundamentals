package com.ab.core.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Arpit Bhardwaj
 */
public class WritingFiles {
    public static void main(String[] args) {
        Path path = Paths.get("files/debug.log");

        try (BufferedWriter writer1 = Files.newBufferedWriter(path);
             BufferedWriter writer2 =new BufferedWriter(writer1);
             PrintWriter printWriter = new PrintWriter(writer2);) {
            writer1.write("Hello World!");
            printWriter.printf("\ni = %d\n", 12);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done!");
    }
}
