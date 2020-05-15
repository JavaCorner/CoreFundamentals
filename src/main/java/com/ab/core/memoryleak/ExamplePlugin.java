package com.ab.core.memoryleak;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arpit Bhardwaj
 */
public class ExamplePlugin{
    public static final long[] LOTS_OF_MEMORY = new long[8*1024*1024];

    private class ExamplePluginLevel extends Level{

        protected ExamplePluginLevel() {
            super("Example Plugin Log Level", 1000);
        }
    }

    private ExamplePluginLevel level = new ExamplePluginLevel();
    private static final Logger logger = Logger.getLogger(ExamplePlugin.class.getName());
    public void initialize() {
        logger.log(level,"Hello World");
    }

}
