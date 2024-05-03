package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * Identifiers Naming Rules (variable, method, class, interface, or package)
 *      Allowed (letters, numbers, $, _)
 *      An identifier name must begin with a letter, dollar sign ($), or underscore (_).
 *      Numbers are permitted only for subsequent characters
 *      Since Java 9, a single underscore _ is not allowed as an identifier., though single dollar sign is allowed
 *
 * DECLARING MULTIPLE VARIABLES
 *      The shortcut to declare multiple variables in the same statement is legal only when they share a type.
 *
 */
public class NamingRules {
    public static void main(String[] args) {
        //allowed
        long okidentifier;
        float $OK2Identifier;
        boolean _alsoOK1d3ntifi3r;
        char __SStillOkbutKnotsonice$;

        //not allowed
        //int 3DPointClass;     // identifiers cannot begin with a number
        //byte hollywood@vine;  // @ is not a letter, digit, $ or _
        //String *$coffee;      // * is not a letter, digit, $ or _
        //double public;        // public is a reserved word
        //short _;              // a single underscore is not allowed
        var var = 1;            //var is a reserved type name noy a keyword
        boolean b1, b2;
        String s1 = "1", s2;
        //double d1, double d2;
        int i1; int i2;
        //int i3; i4;
    }
}
