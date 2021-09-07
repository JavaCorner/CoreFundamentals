package com.ab.core.trywithresource;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Arpit Bhardwaj
 *
 * If exceptions are thrown from both the try block and the try-with-resources statement,
 * exception from the try block is thrown and exception from the try-with-resources statement is suppressed.
 *
 * Closeable extends AutoCloseable and Closeable is mainly directed to IO streams.
 * Closeable close throws IOException whereas AutoCloseable close throws Exception.
 * Closeable interface is idempotent (calling close() method more than once does not have any side effects) whereas AutoCloseable does not provide this feature.
 */
public class TryWithResourceDemo1 {
    public static void main(String[] args) {
        var resource1 = new Closeable(){

            @Override
            public void close() throws IOException {
                System.out.println("Closeable -> Close");
                throw new IOException();
            }
        };

        var resource2 = new AutoCloseable(){

            @Override
            public void close() throws Exception {
                System.out.println("AutoCloseable -> Close");
                throw new IllegalArgumentException();
            }
        };

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
