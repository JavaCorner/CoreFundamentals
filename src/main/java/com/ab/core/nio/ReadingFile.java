package com.ab.core.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Arpit Bhardwaj
 */
public class ReadingFile {
    public static void main(String[] args) {
        //Path path = Paths.get("files/sonnet-UTF8.txt");
        Path path = Paths.get("files/sonnet-ISO.txt");
        boolean exists = Files.exists(path);
        System.out.println("File Exists : " + exists);

        //BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);
        try (BufferedReader reader = Files.newBufferedReader(path);) {
            String line = reader.readLine();
            while (line != null){
                System.out.println("Line = " + line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
