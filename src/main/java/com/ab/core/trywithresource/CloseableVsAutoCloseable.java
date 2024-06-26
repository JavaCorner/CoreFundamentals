package com.ab.core.trywithresource;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Arpit Bhardwaj
 *
 * If exceptions are thrown from both the try block and the try-with-resources statement,
 * exception from the try block is thrown and exception from the try-with-resources statement is suppressed.
 *
 * AutoCloseable
 *      Closeable
 *
 * Closeable close throws IOException whereas AutoCloseable close throws Exception.
 * Closeable interface is idempotent (calling close() method more than once does not have any side effects) whereas AutoCloseable does not provide this feature.
 */
public class CloseableVsAutoCloseable {
    public static void main(String[] args) {
        var resource0 = new Closeable() {
            @Override
            public void close() {
                System.out.println("resource0 -> Closeable -> Close");
            }
        };

        var resource1 = new Closeable(){
            @Override
            public void close() throws IOException {
                System.out.println("resource1 -> Closeable -> Close");
                throw new IOException();
            }
        };

        var resource2 = new AutoCloseable(){
            @Override
            public void close() throws Exception {
                System.out.println("resource2 -> AutoCloseable -> Close");
                throw new IllegalArgumentException();
            }
        };
        //try with resource can exist without catch and finally which is not the case of normal try
        try (resource0){}

        try (resource1;resource2;){
            System.out.println("try with resource block");
            throw new NullPointerException();
            //all close operation of resources mentioned in try() done here in reverse manner
        } catch (Exception e) {
            System.out.println(e);
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable s:
                 suppressed) {
                System.out.println(s);
            }
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }
}
