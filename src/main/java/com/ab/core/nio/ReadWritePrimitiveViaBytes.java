package com.ab.core.nio;

import java.io.*;

/**
 * @author Arpit Bhardwaj
 *
 */
public class ReadWritePrimitiveViaBytes {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6};
        byte[] bytes = {};

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(bos)){
            for (int i:
                 ints) {
                dos.writeInt(i);
            }
            dos.flush();
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Bytes Length : " + bytes.length);

        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             DataInputStream dis = new DataInputStream(bis);){
            for (int i = 0; i < 5; i++) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
