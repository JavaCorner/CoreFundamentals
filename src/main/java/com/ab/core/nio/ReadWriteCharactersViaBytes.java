package com.ab.core.nio;

import java.io.*;

/**
 * @author Arpit Bhardwaj
 *
 * In case you want to read/write characters in byte stream
 * There are 2 classes that act as a bridge between characters and bytes.
 *      OutputStreamWriter : Eventually a writer built upon outputstream
 *      InputStreamReader : Eventually a reader built upon inputstream
 *
 *  Tip: Memorize it as the name contains both Stream and Reader/Writer
 */
public class ReadWriteCharactersViaBytes {
    public static void main(String[] args) {
        String data = "Hello World";

        byte[] bytes = {};

        // OutputStreamWriter convert characters to bytes
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             OutputStreamWriter writer = new OutputStreamWriter(bos)){
            writer.write(data);
            writer.flush();
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Bytes Length : " + bytes.length);

        // InputStreamReader convert bytes to characters
        //Using BufferReader as it contains convenient methods such as readLine
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             InputStreamReader isr = new InputStreamReader(bis);
             BufferedReader reader = new BufferedReader(isr)){
            System.out.println(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
