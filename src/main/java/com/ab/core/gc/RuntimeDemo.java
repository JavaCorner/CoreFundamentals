package com.ab.core.gc;

import java.io.IOException;

/**
 * @author Arpit Bhardwaj
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total Memory : " + runtime.totalMemory());
        System.out.println("Free Memory : " + runtime.freeMemory());
        System.out.println("Max Memory : " + runtime.maxMemory());
        System.out.println("Available Processors : " + runtime.availableProcessors());

        //runtime.gc();
        //runtime.runFinalization();
        //executeCommand(runtime);
    }

    private static void executeCommand(Runtime runtime) {
        //executeCommandUsingRuntime(runtime);
        executeCommandUsingProcessBuilder();
    }

    private static void executeCommandUsingProcessBuilder() {
        try {
            ProcessBuilder pb =
                    new ProcessBuilder(
                            "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
                            "youtube.com");

            pb.start();

            System.out.println("Google Chrome launched!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeCommandUsingRuntime(Runtime runtime) {
        try {
            Process process = runtime.exec(new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
                    "youtube.com"});
            System.out.println("Google Chrome successfully started");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
