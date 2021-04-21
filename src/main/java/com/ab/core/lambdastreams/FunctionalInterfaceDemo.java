package com.ab.core.lambdastreams;

/**
 * @author Arpit Bhardwaj
 *
 * Function (unary function from T to R) -> apply
 * Supplier (nullary function to R) -> get
 * Consumer (unary function from T to void) -> accept
 * Predicate (unary function from T to boolean) -> test
 *
 * BiFunction (bi function from T, U to R)
 * BiConsumer (bi function from T, U to void)
 * BiPredicate (bi function from T, U to boolean)
 *
 * UnaryOperator (extends Function) -> identity
 * BinaryOperator (extends BiFunction) -> minBy, maxBy
 *
 * Specialized Functional Interfaces are present for int, long, double
 *                  "PrefixToSuffixInterface"
 *
 *                  Before To will be taken types
 *                  After To will be return type
 *
 *                  In case return type is generic To will be omitted.
 *
 * IntFunction (Function) Take int return R
 * ToIntFunction (Function) Take T return int
 * IntToDoubleFunction (Function) (takes int return double)
 * IntToLongFunction (Function)
 * LongToIntFunction (Function)
 * LongToDoubleFunction (Function)
 * DoubleToIntFunction (Function)
 * DoubleToLongFunction (Function)
 * ToIntBiFunction (Bi Function) Take T, U return int
 * ToLongBiFunction (Bi Function) Take T, U return long
 * ToDoubleBiFunction (Bi Function) Take T, U return double
 *
 */
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

    }
}
