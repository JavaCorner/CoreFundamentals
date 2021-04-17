package com.ab.core.lambdastreams;

import com.ab.core.lambdastreams.model.Product;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author Arpit Bhardwaj
 *
 */
public class GeneratingBuilding {
    public static void main(String[] args) {
        //randomUUID signature matches with Supplier get method
        Stream<UUID> uuids = Stream.generate(UUID::randomUUID);
        uuids.limit(5).forEach(System.out::println);

        //takes seed value, unary
        Stream<BigInteger> powerOfTwo = Stream.iterate(BigInteger.ONE, n -> n.multiply(BigInteger.TWO));
        powerOfTwo.limit(8).forEach(System.out::println);

        //takes seed value, predicate, unary
        Stream<Character> atoz = Stream.iterate('A', letter -> letter <= 'Z', letter -> (char) (letter + 1));
        atoz.forEach(System.out::print);

        Stream.Builder<String> stringBuilder = Stream.builder();
        stringBuilder.add("one");
        stringBuilder.add("two");
        stringBuilder.add("three");

        Stream<String> stringStream = stringBuilder.build();
        stringStream.forEach(System.out::println);

    }
}
