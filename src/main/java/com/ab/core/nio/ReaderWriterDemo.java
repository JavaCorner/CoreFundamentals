package com.ab.core.nio;

import java.io.*;

/**
 * @author Arpit Bhardwaj
 *
 * Writer is to write characters
 * Low level implementation of Writer are
 *      FileWriter : disk writer
 *      StringWriter : in memory (doesn't violate string immutable, write internally in buffer)
 *      CharArrayWriter : in memory
 *
 *      In Memory readers support marking and resetting
 *
 * Reader is to read characters
 * Low level implementation of Reader are
 *      FileReader : disk reader
 *      StringReader : in memory
 *      CharArrayReader : in memory
 *
 *      In Memory readers support marking and resetting
 *
 */
public class ReaderWriterDemo {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("files/words.txt")) {
            //write method erase the content of file and write the new content
            //append method just append the new content in existing content
            //writer close will implicitly call flush also
            writer.write("Hello World!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(StringWriter writer = new StringWriter();
            var t = System.out) {
            writer.write("Hello World!");// write chars to internal buffer, hence explicit flush required to flush
            writer.flush();
            writer.write('c');
            StringBuffer buf = writer.getBuffer();
            t.println(buf.toString());
            t.println(writer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("d");//at this out will be closed, hence this has no affect
        }


        try (Reader reader = new FileReader("files/sonnet-ISO.txt");) {
            int length;
            char[] buf = new char[16];
            StringBuilder sb = new StringBuilder();
            while((length = reader.read(buf)) > 0){
                sb.append(buf,0,length);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
