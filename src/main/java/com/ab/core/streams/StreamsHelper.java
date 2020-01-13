package com.ab.core.streams;

import java.io.*;
//java.io.FileXXX are deprecated
//java.nio.file is the preffered


public class StreamsHelper {

    public static Reader openReader(String s) throws FileNotFoundException {
        FileReader fileReader = new FileReader(s);
        return fileReader;
    }

    public static Reader openBufferedReader(String s) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(s));
        return bufferedReader;
    }

    public static Writer openWriter(String s) throws IOException {
        FileWriter fileWriter = new FileWriter(s);
        return fileWriter;
    }
}
