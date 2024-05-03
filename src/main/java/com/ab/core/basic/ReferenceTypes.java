package com.ab.core.basic;

/**
 * @author Arpit Bhardwaj
 *
 * A local variable is a variable defined within a constructor, method, or initializer block.
 * Local variables do not have a default value and must be initialized before use.
 *
 * Variables that are not local variables are defined either as instance variables or as class variables.
 * Instance and class variables do not require you to initialize them, they get default values as below
 *
 * Variable type	                            Default initialization value
 * boolean	                                    false
 * byte, short, int, long	                    0
 * float, double	                            0.0
 * char	                                        '\u0000' (NUL)
 * All object references (everything else)	    null
 *
 *
 * INTRODUCING VAR ( local variable type inference)
 *
 * A var is used as a local variable in a constructor, method, or initializer block.
 * A var is a reserved type name but not a reserved word, meaning it can be used as an identifier except as a class, interface, or enum name.
 * A var should always be initialized on the same line (or statement) where it is declared.
 * The value of a var can change, but the type cannot.
 *
 * A var cannot be used in below scenario
 *      A var cannot be used in constructor parameters, method parameters, method return types, instance variables, or class variables.
 *      A var cannot be initialized with a null value without a type.
 *      A var is not permitted in a multiple-variable declaration.
 *      A var cannot be used as array initializers.
 *
 * REVIEWING SCOPE
 *
 * Local variables: In scope from declaration to end of block
 * Instance variables: In scope from declaration until object eligible for garbage collection
 * Class variables: In scope from declaration until program ends
 */
public class ReferenceTypes {
    static int i;
    //var k = 2;                //not compile as var is only allowed for local variables
    public static void main(String[] args) {

        int j;
        //System.out.println(j);//not compile as initialization is necessary for local variables

        System.out.println(i);

        //var l;                //DOES NOT COMPILE
        //var a = 2, b = 3;     // DOES NOT COMPILE
        //var n = null;         // DOES NOT COMPILE
        //var[] prices = {1,2}; // DOES NOT COMPILE

        var n = (String)null;
    }

    public void reassignment() {
        var number = 7;
        number = 4;
        //number = "five";      // DOES NOT COMPILE

        var apples = (short)10;
        apples = (byte)5;
        //apples = 1_000_000;  // DOES NOT COMPILE
    }

    /*public int addition(var a, var b) {  // DOES NOT COMPILE
        return a + b;
    }*/

    //var is not a reserved word and allowed to be used as an identifier, it is considered a reserved type name.
    // A reserved type name means it cannot be used to define a type, such as a class, interface, or enum.
    public class Var {
        public void var() {
            var var = "var";
        }
        public void Var() {
            Var var = new Var();
        }
    }

    /*public class var {        // DOES NOT COMPILE
        public var() {
        }
    }*/
}
