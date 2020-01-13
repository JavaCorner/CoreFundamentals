package com.ab.core.streams;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable {

    public void saySomething() throws IOException {
        throw new IOException("Exception from saySomething");
        //System.out.println("Say Something !!");
    }
    @Override
    public void close() throws Exception {
        throw new IOException("Exception from Close");
        //System.out.println("close");
    }
}
