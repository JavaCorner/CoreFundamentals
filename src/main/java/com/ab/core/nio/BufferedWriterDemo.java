package com.ab.core.nio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Arpit Bhardwaj
 */
public class BufferedWriterDemo {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("files/words.txt")) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Buffered Writer Hello 1!");//this will only write to internal buffer, hence explicit flush is required
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(Writer writer = new FileWriter("files/words.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);) {
            bufferedWriter.write("Buffered Writer Hello 2!");
            //bufferedWriter.flush();//not required as it will be called as part of close in try with resource
        } catch (IOException e) {
            e.printStackTrace();
        }


        Path path = Path.of("files/words.txt");
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path);) {
            bufferedWriter.write("Buffered Writer Hello 3!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
