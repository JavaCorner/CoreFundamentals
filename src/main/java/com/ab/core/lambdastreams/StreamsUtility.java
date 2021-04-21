package com.ab.core.lambdastreams;

import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Arpit Bhardwaj
 *
 * The parallel() method of the BaseStream interface returns an equivalent parallel stream.
 * The parallelStream() method of the Collection interface returns a possible parallel stream with the collection as the source.
 *
 */
public class StreamsUtility {
    public static void main(String[] args) {
        List<String> c = List.of("a", "b", "c","d", "e");

        c.forEach(System.out::print);
        System.out.println();
        c.stream().forEach(System.out::print);
        System.out.println();
        c.parallelStream().forEach(System.out::print);
        System.out.println();


        //The behavior of findAny operation is explicitly nondeterministic; it is free to select any element in the stream
        //without paying an attention to the encounter order

        //ordered stream - serial -> it will most likely return the first element in the Stream but there is no guarantee for this.
        //ordered stream -parallel -> return any element
        //unordered stream - serial/parallel -> return any element
        IntStream.range(0,500).findAny().ifPresent(System.out::println);
        IntStream.range(0,500).parallel().findAny().ifPresent(System.out::println);

        //ordered stream - serial/parallel -> returns the first element in encounter order
        //unordered stream - serial/parallel -> return any element

        //Nutshell behavior of the findFirst method does not change in the parallel scenario.
        IntStream.range(0,500).findFirst().ifPresent(System.out::println);
        IntStream.range(0,500).parallel().findFirst().ifPresent(System.out::println);

        //limit returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length
        IntStream.range(0,500).limit(5).forEach(System.out::println);

        //skip Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.
        IntStream.range(0,10).skip(5).forEach(System.out::println);

        //Returns the count of elements in this stream. its a reduction terminal operation
        IntStream.range(0,10).count();

        c.stream().parallel();
        c.parallelStream().parallel();

        // After calling a terminal method on stream it gets closed
        // If you try to call any operation on closed stream, IllegalStateException is thrown

        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        System.out.println(stream.anyMatch(s -> true));
        //System.out.println(stream.noneMatch(s -> true));   // IllegalStateException as the stream is closed

        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        System.out.println(streamSupplier.get().anyMatch(s -> true));
        System.out.println(streamSupplier.get().noneMatch(s -> true));

        //For sequential stream, forEach guarantee to respect the encounter order of the stream
        //For parallel stream, forEach does not guarantee to respect the encounter order of the stream
        Stream.of("A","B","C").parallel().forEach(System.out::print);
        System.out.println();
        //forEachOrdered will processes the elements of the stream in the order specified by its source,
        // regardless of whether the stream is sequential or parallel.
        //forEachOrdered() method to its elements, which will force the parallel stream into a single‐threaded state.
        Stream.of("A","B","C").parallel().forEachOrdered(System.out::print);
        System.out.println();

        //peek is an intermediate operation
        Random r = new Random();
        Stream.generate(r::nextInt)
                .skip(2)
                .limit(4)
                .sorted()
                .peek(System.out::println)
                .forEach(System.out::println);

/*        var dice = new TreeSet<Integer>();
        dice.add(6);
        dice.add(6);
        dice.add(4);

        dice.stream()
                .filter(n -> n != 4)
                .forEach(System.out::println)
                .count();*/

    }
}
