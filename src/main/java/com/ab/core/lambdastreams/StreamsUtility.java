package com.ab.core.lambdastreams;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Arpit Bhardwaj
 *
 * The parallel() method of the BaseStream interface returns an equivalent parallel stream.
 * The parallelStream() method of the Collection interface returns a possible parallel stream with the collection as the source.
 *
 */
public class StreamsUtility {
    public static void main(String[] args) {
        List<String> c = List.of("c", "b", "d", "e", "z", "y","j","k","n","o");

        //The behavior of findAny operation is explicitly nondeterministic; it is free to select any element in the stream
        //without paying an attention to the encounter order
        //In a non-parallel stream, it will most likely return the first element in the Stream but there is no guarantee for this.
        //in a parallel operation the result cannot be determined
        IntStream.range(0,500).findAny().ifPresent(System.out::println);
        IntStream.range(0,500).parallel().findAny().ifPresent(System.out::println);

        //findFirst returns th first element in encounter order
        //in case of no order it behaves as findAny()
        //The behavior of the findFirst method does not change in the parallel scenario.
        IntStream.range(0,500).findFirst().ifPresent(System.out::println);
        IntStream.range(0,500).parallel().findFirst().ifPresent(System.out::println);

        c.stream().parallel();
        c.parallelStream().parallel().parallel();
    }
}
