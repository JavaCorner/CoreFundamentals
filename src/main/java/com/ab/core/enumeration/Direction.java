package com.ab.core.enumeration;

/**
 * @author Arpit Bhardwaj
 *
 * Direction is enum which is implicitly extends Enum, hence Direction is instance of Enum
 *      enums are implicitly final subclasses of class java.lang.Enum
 *      ordinal(), values() and valueOf() are implicitly inherited from Enum abstract class
 */


public enum Direction {
    EAST, WEST, NORTH, SOUTH;

    public static void main(String[] args) {
        //enum values() method returns all the enum values in an enum array
        Direction[] directions = Direction.values();
        for (Direction direction:
                directions) {
            System.out.println(direction + " : " + direction.ordinal());
        }
        //enum valueOf() method helps to convert string to enum instance.
        Direction east = Direction.valueOf("EAST");
        System.out.println(east);
        Direction eastNew = Direction.EAST;

        //since enums are singleton and comparable by default.
        //You can compare enum types using '==' operator or equals() method
        System.out.println( east == eastNew );
        System.out.println( east.equals( eastNew ) );
    }
}

//given enum can be seen as below declaration internally by JVM
/*final class Direction extends Enum<Direction>
{
    public static final Direction EAST = new Direction();
    public static final Direction WEST = new Direction();
    public static final Direction NORTH = new Direction();
    public static final Direction SOUTH = new Direction();
}*/


