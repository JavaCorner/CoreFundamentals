package com.ab.core.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Arpit Bhardwaj
 *
 *
 */
public class WrapExceptions {
    public static void main(String[] args) {
        try {
            doThings();
        } catch (NameNotFoundException e) {
            System.out.println(e.getMessage());
            Throwable cause = e.getCause();
            System.out.println(cause.getMessage());
        }

    }

    private static void doThings() throws NameNotFoundException {
        try(Reader in = new FileReader("some.txt")){
            char[] buffer = new char[1024];
            in.read(buffer);
        } catch (FileNotFoundException e) {
            throw new NameNotFoundException("Failed to find the file", e);
        } catch (IOException e) {
            throw new NameNotFoundException("Failed to read text", e);
        }
    }
}
