package com.ab.core.exception;

import java.io.*;

/**
 * @author Arpit Bhardwaj
 *
 * Throwable <- Exception <- IOException
 *
 * java.lang.Exception
 * java.io.IOException
 * java.io.FileNotFoundException, java.io.EOFException
 *
 * java.lang.Exception
 * java.lang.ReflectiveOperationException
 * java.lang.ClassNotFoundException, java.lang.NoSuchMethodException
 *
 */
public class CheckedException {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            throw new Exception();
        }catch (FileNotFoundException | EOFException e){

        }catch (IOException e){

        }catch (Exception e){

        }catch (Throwable e){

        }
    }
}
