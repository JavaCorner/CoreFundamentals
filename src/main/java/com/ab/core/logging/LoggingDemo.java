package com.ab.core.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arpit Bhardwaj
 *
 * 7 Levels
 * SEVERE -> WARNING -> INFO -> CONFIG -> FINE -> FINER -> FINEST
 *
 * Setting the level means ignore the messages more detailed than the set one
 */
public class LoggingDemo {

    private static Logger logger = Logger.getLogger(LoggingDemo.class.getName());

    public static void main(String[] args) {
        logger.setLevel(Level.INFO);
        logger.entering(LoggingDemo.class.getName(),"main");
        try{

        }catch (Exception e){
            logger.log(Level.SEVERE, "Severe Error Message", e);
        }
        logger.log(Level.INFO,"Info Message1");
        logger.info("Info Message2");

        logger.log(Level.FINE,"Fine Message");//this message will not be recorded anywhere as the level set to info

        //use below approach to check first the what level has been set
        if (logger.isLoggable(Level.FINER)){
            logger.log(Level.FINE,"Fine Message");
        }
        logger.exiting(LoggingDemo.class.getName(),"main");
    }
}
