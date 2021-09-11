package com.ab.core.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Arpit Bhardwaj
 *
 * Buffered Reader extends from Reader
 *  Following Decorator pattern, Buffered Reader is the decoration of Reader
 */
public class BufferedReaderWriterDemo {
    public static void main(String[] args) {
        Path path = Path.of("files/sonnet-ISO.txt");

        try(Reader reader = new FileReader(path.toFile());
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("********************************************");
        //using Files class
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

        try(Writer writer = new FileWriter("files/words.txt")) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Buffered Writer Hello 1!");//this will only write to internal buffer, hence explicit flush is required
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //or

        try(Writer writer = new FileWriter("files/words.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.write("Buffered Writer Hello 2!");
            //bufferedWriter.flush();//not required as it will be called as part of close in try with resource
        } catch (IOException e) {
            e.printStackTrace();
        }

        //or

        Path path2 = Path.of("files/words.txt");
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path2);) {
            bufferedWriter.write("Buffered Writer Hello 3!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
