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
        executeCommand(runtime);
    }

    private static void executeCommand(Runtime runtime) {
        //String chromeAppPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        String chromeAppPath = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
        String siteUrl = "youtube.com";
        executeCommandUsingRuntime(runtime, chromeAppPath, siteUrl);
        //executeCommandUsingProcessBuilder(chromeAppPath, siteUrl);
    }

    private static void executeCommandUsingProcessBuilder(String appPath, String siteUrl) {
        try {
            ProcessBuilder pb = new ProcessBuilder(appPath, siteUrl);
            pb.start();
            System.out.println("Google Chrome launched!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeCommandUsingRuntime(Runtime runtime, String appPath, String siteUrl) {
        try {
            runtime.exec(new String[]{appPath,siteUrl});
            System.out.println("Google Chrome successfully started");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
