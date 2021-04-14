package com.ab.core.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Arpit Bhardwaj
 *
 * Buffered Reader extends from Reader
 *  Following Decorator pattern, Buffered Reader is the decoration of Reader
 */
public class BufferedReaderDemo {
    public static void main(String[] args) {
        Path path = Path.of("files/sonnet-ISO.txt");
        try(BufferedReader bufferedReader = Files.newBufferedReader(path);) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("********************************************");
        //or by stream api lines()
        try(BufferedReader bufferedReader = Files.newBufferedReader(path);) {
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
