package com.ab.core.memoryleak;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpit Bhardwaj
 */
public class OffHeapLeak {
    private static final int BUFFER_SIZE = 64 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        List<ByteBuffer> byteBuffers = new ArrayList<>();

        while (true){
            byteBuffers.add(ByteBuffer.allocateDirect(BUFFER_SIZE));
            System.out.println("Press any key to continue");
            System.in.read();
        }
    }
}
