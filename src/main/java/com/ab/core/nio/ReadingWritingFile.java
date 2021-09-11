package com.ab.core.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Arpit Bhardwaj
 */
public class ReadingWritingFile {
    public static void main(String[] args) {
        //Path path = Paths.get("files/sonnet-UTF8.txt");
        Path path = Paths.get("files/sonnet-ISO.txt");
        boolean exists = Files.exists(path);
        System.out.println("File Exists : " + exists);

        //BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);
        //Files newBufferedReader give directly the BufferedReader else you need to connect Reader with BufferedReader
        try (BufferedReader reader = Files.newBufferedReader(path);) {
            String line = reader.readLine();
            while (line != null){
                System.out.println("Line = " + line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path2 = Paths.get("files/debug.log");

        try (BufferedWriter writer1 = Files.newBufferedWriter(path2);
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
