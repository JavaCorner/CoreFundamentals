package com.ab.core.nio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Arpit Bhardwaj
 *
 * Reader is meant to read characters only
 * Reader is an abstract class whose main extensions are below
 *
 *      FileReader : disk reader
 *      StringReader : in memory reader
 *      CharArrayReader : in memory
 *
 *      In Memory readers support marking and resetting
 */

public class ReaderDemo {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("files/sonnet-ISO.txt");) {
            int length;
            char[] buf = new char[16];
            StringBuilder sb = new StringBuilder();
            while((length = reader.read()) >= 0){
                sb.append(buf,0,length);
            }

            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
