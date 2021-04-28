package com.ab.core.oop.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Arpit Bhardwaj
 * Top Level Modifiers:
 * public,default
 * Member Level Modifiers
 * public,protected,default,private
 *
 * public: member is visible to all the classes everywhere.
 * private: member is visible only inside its own class.
 * protected: member is visible only in its own package or by subclass of its class in any other package.
 * Package Private (No Modifier): member is visible only in its own package
 *
 * Top-level classes or interfaces can not be declared as private or protected because
 *      private means “only visible within the enclosing class”.
 *      protected means “only visible within the enclosing class and any subclasses”
 */

public class FlightPlan extends Flight{
    String id;
    String departure;
    String destination;
    LocalDateTime departureTime;
    List<String> route;

    private FlightPlan(){
        super("Test Flight");//without this line there will be a compile error as there is no  noarg constructor in parent
        System.out.println("FlightPlan()");
        this.id = UUID.randomUUID().toString();
    }

    static {
        //this code is executed only once: the first time the class is loaded into memory
        System.out.println("FlightPlan Static block 1");
    }
    {
        System.out.println("FlightPlan IIB 1");
    }
    static {
        System.out.println("FlightPlan Static block 2");
    }

    {
        System.out.println("FlightPlan IIB 2");
    }


    public FlightPlan(String departure, String destination){
        this();//should be the first line else will be compiler error
        if(departure == null || destination == null){
            throw new IllegalArgumentException();
        }
        System.out.println(String.format("FlightPlan(%s,%s)",departure,destination));
        this.departure = departure;
        this.destination = destination;
    }

    public FlightPlan(String departure, String destination, LocalDateTime departureTime, List<String> route) {
        this(departure,destination);//should be the first line else will be compiler error

        if(departureTime == null || route == null){
            throw new IllegalArgumentException();
        }
        System.out.println(String.format("FlightPlan(%s,%s,%s,%s)",
                departure,
                destination,
                departureTime.toLocalTime(),
                route.toString()));

        this.departureTime = departureTime;
        this.route = route;
    }

    {
        // This code is executed whenever any constructor is invoked (before the constructor’s contents)
        System.out.println("FlightPlan IIB 3");
    }
    @Override
    public String toString() {
        return "FlightPlan{" +
                "id='" + id + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", route=" + route +
                '}';
    }

}
