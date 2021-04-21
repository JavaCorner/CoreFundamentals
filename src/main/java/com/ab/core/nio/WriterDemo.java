package com.ab.core.nio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Arpit Bhardwaj
 *
 * Writer is meant to write characters only
 * Writer is an abstract class whose main extensions are below
 *
 *      FileWriter : disk writer
 *      StringWriter : in memory writer (doesnt not violate string immutable, write internally in buffer)
 *      CharArrayWriter : in memory writer
 *
 *      In Memory readers support marking and resetting
 */
public class WriterDemo {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("files/words.txt")) {
            //write method erase the content of file and write the new content
            //append method just append the new content in existing content
            //writer close will implicitly call flush also
            writer.write("Hello World!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(StringWriter writer = new StringWriter(); var t = System.out) {
            writer.write("Hello World!");// write chars to internal buffer, hence explicit flush required to flush
            writer.flush();
            writer.write('c');
            StringBuffer buf = writer.getBuffer();
            System.out.println(buf.toString());
            System.out.println(writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
