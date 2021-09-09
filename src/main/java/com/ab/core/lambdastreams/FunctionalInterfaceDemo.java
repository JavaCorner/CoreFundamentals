package com.ab.core.lambdastreams;

import java.util.*;
import java.util.function.*;

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
        //Function
        Function<Integer,Double> f1 = x -> 2.0 * x;
        UnaryOperator<Integer> f2 = x -> 2 * x;
        BiFunction<Integer,Integer,Double> f3 = (x,y) -> 2.0*x*y;
        BinaryOperator<Integer> f4 = (x,y)-> Math.max(x,y);

        IntFunction<Integer> f5 = (int x) -> 2*x;
        ToIntFunction<Integer> f6 = (Integer x) -> 2*x;
        IntToDoubleFunction f7 = x -> 2.0*x;

        //predicate
        Predicate<String> p1 = x -> true;
        Predicate<String> p2 = (var x) -> true;
        Predicate<String> p3 = (String x) -> true;
        Predicate<String> p4 = (final var x) -> true;
        Predicate<String> p5 = (final String x) -> true;
        //Predicate<String> p6 = (final x) -> true;                     //not allowed

        //consumer
        Consumer<String> c1 = x -> System.out.println(x);

        //supplier
        Supplier<Integer> random = () ->  new Random().nextInt();

        //comparator
        Comparator<String> reverseOrder1 = Comparator.reverseOrder();
        Comparator<String> reverseOrder2 = (s1, s2) -> s2.compareTo(s1);
        Comparator<String> reverseOrder3 = (s1, s2) -> - s1.compareTo(s2);

        //calling collection APIs with lambda

        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");

        //removeIf (takes predicate)
        bunnies.removeIf(s-> s.charAt(0) != 'h');

        //sort
        bunnies.sort((a,b) -> a.compareTo(b));
        bunnies.sort(Comparator.naturalOrder());

        //foreach (takes consumer)
        bunnies.forEach(a -> System.out.println(a));


        Map<String, Integer> bunny = new HashMap<>();
        bunny.put("long ear", 3);
        bunny.put("floppy", 8);
        bunny.put("hoppy", 1);
        //foreach (takes biconsumer)
        bunny.forEach((k, v) -> System.out.println(k + " " + v));

    }
}
