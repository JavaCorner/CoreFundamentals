package com.ab.core.enumeration;

/**
 * @author Arpit Bhardwaj
 *
 * each enum is an instance of enum type itself
 * Direction is enum which is implicitly extends Enum, hence Direction is instance of Enum
 *
 * 1.enums are implicitly final subclasses of java.lang.Enum class
 * 2.enum constants (or enum instances) are implicitly public static final
 * 3.ordinal(), values() and valueOf() are implicitly inherited from Enum abstract class
 * 4.As noted all enums extends java.lang.Enum, so enum cannot extend any other class because Java does not support multiple inheritance this way.
 *   But enums can implement any number of interfaces.
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



