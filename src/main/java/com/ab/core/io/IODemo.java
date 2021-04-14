package com.ab.core.io;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * @author Arpit Bhardwaj
 */
public class IODemo {
    public static void main(String[] args) throws Exception {
        doTryCatchFinally();
        //doTryWithResources();
        //doTryWithResourcesMulti();
        //doClose();
    }
    //Reader class for text
    //InputStream for bytes
    private static void doClose() throws Exception {
        //Need to handle closing separately
        /*MyAutoCloseable myAutoCloseable = new MyAutoCloseable();
        try {
            myAutoCloseable.saySomething();
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + "-" + e.getMessage());
        }*/

        try (MyAutoCloseable myAutoCloseable = new MyAutoCloseable()){
            myAutoCloseable.saySomething();
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + "-" + e.getMessage());
            for (Throwable T:
                 e.getSuppressed()) {
                System.out.println("Suppressed : " + T.getClass().getSimpleName() + "-" +T.getMessage());
            }
        }
    }

    private static void doTryWithResourcesMulti() {
        char[] buffer = new char[8];
        int length;
        try (Reader reader = IOHelper.openReader("file1.txt")
             ; Writer writer = IOHelper.openWriter("files2.txt")){
            while ((length = reader.read(buffer))>= 0){
                System.out.println("\nlength: " + length);
                writer.write(buffer,0,length);
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + "-" + e.getMessage());
        }
    }

    private static void doTryWithResources() {
        char[] buffer = new char[8];
        int length;
        try (Reader reader = IOHelper.openReader("file1.txt")){
            while ((length = reader.read(buffer))>= 0){
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++) {
                    System.out.print(buffer[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + "-" + e.getMessage());
        }
    }

    private static void doTryCatchFinally() {
        char[] buffer = new char[8];
        Reader reader = null;
        int length;
        try {
            reader = IOHelper.openBufferedReader("file1.txt");
            while ((length = reader.read(buffer))>= 0){
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++) {
                    System.out.print(buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getClass().getSimpleName() + "-" + e.getMessage());
            }
        }
    }
}
