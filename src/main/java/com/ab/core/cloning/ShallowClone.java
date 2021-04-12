package com.ab.core.cloning;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arpit Bhardwaj
 *
 *
 */
public class ShallowClone {
    private static final Logger logger = Logger.getLogger(ShallowClone.class.getName());

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(20,30);

        Rectangle rectangleCopy = null;

        logger.setLevel(Level.INFO);

        logger.info(rectangle.toString());
        try {
            rectangleCopy = rectangle.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        logger.info(rectangleCopy.toString());
        //1st rule a.clone() != a
        logger.info("Rule 1:a.clone() != a " + (rectangleCopy != rectangle));

        //2st rule a.clone().getClass() == a.getClass()
        logger.info("Rule 2:a.clone().getClass() == a.getClass() " + (rectangleCopy.getClass() == rectangle.getClass()));

        //3st rule clone.equals(a)
        logger.info("Rule 3:a.clone().equals(a) " + rectangleCopy.equals(rectangle));
    }
}
