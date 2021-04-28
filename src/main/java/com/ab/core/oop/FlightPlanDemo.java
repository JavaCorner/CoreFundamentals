package com.ab.core.oop;

import com.ab.core.oop.model.FlightPlan;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author Arpit Bhardwaj
 */
public class FlightPlanDemo {
    public static void main(String[] args) {
        FlightPlan berlinTOBucharest = new FlightPlan("BER","OTP");

        System.out.println(berlinTOBucharest);

        /*FlightPlan parisToLondon = new FlightPlan("CDG",
                "LHR",
                LocalDateTime.of(2020,01,10,23,15),
                Arrays.asList(new String[]{"CDG","FGH"}));

        System.out.println(parisToLondon);*/
    }
}
