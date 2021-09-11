package com.ab.core.nio;

import java.io.*;

/**
 * @author Arpit Bhardwaj
 *
 * Output Stream is to write bytes
 * Low level implementation of OutputStream
 *      FileOutputStream
 *      ByteArrayOutputStream
 *      PrintStream
 *
 * Input Stream is to read bytes
 * Low level implementation of InputStream
 *      FileInputStream
 *      ByteArrayInputStream
 *
 */
public class InputOutputStreamDemo {
    public static void main(String[] args) {
        byte[] data = {0xC, 0xA, 0xF, 0xE, 0xB, 0xA, 0xB, 0xE};

        try(OutputStream outputStream = new FileOutputStream("files/byte.bin")) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(InputStream inputStream = new FileInputStream("files/byte.bin")) {
            byte[] allBytes = inputStream.readAllBytes();
            for (byte allByte:
                 allBytes) {
                System.out.printf("0x%x ",allByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
