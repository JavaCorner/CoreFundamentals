package com.ab.core.lambdastreams;

import com.ab.core.lambdastreams.model.Category;
import com.ab.core.lambdastreams.model.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Arpit Bhardwaj
 *
 * Streams may or may not produce elements in specific order
 * List is an ordered collection, hence stream on it produce ordered elements
 * Set is an unordered collection, hence stream on it produce unordered elements
 */
public class StreamsDemo {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        //below line will not do anything as all are intermediate operations
        //any methods that returns streams is an intermediate operation
        //rest are terminal.
        Stream<Product> productStream = products.stream()
                .map(product -> {
                    System.out.println(product);
                    return product;
                });

        productStream.forEach(product -> {});

        //obtaining streams from collection
        Stream<Product> productStream1 = products.stream();

        //obtaining streams from array
        String[] strings = new String[]{"one","two","three"};
        Stream<String> stream0 = Arrays.stream(strings);

        Stream<String> stream1 = Stream.of("one", "two", "three");

        Stream<String> stream2 = Stream.ofNullable("one");

        Stream<Object> stream3 = Stream.empty();

        //other objects which provides stream
        IntStream dice = new Random().ints(1, 7);//gives an infinite stream

        dice.limit(10).forEach(System.out::println);

        try (BufferedReader reader = new BufferedReader(new FileReader("files/words.txt"))){
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //filtering and mapping
        products.stream()
                .filter(product -> product.getCategory()== Category.FOOD)
                .forEach(System.out::println);

        products.stream()
                .map(product -> String.format("The price of %s is $ %.2f",product.getName(),product.getPrice()))
                .forEach(System.out::println);

        products.stream()
                .flatMap(product -> Pattern.compile("\\s").splitAsStream(product.getName()))
                .forEach(System.out::println);

        //searching
        Optional<Product> firstOfficeProduct = products.stream()
                .filter(product -> product.getCategory() == Category.OFFICE)
                .findFirst();

        firstOfficeProduct.ifPresent(System.out::println);

        //in case the stream produce unordered elements then findFirst and findAny has no difference
        //in case the stream produce ordered elements then findFirst element which first match the filter criteria and findAny return any random
        //match
        Optional<Product> anyOfficeProduct = products.stream()
                .filter(product -> product.getCategory() == Category.OFFICE)
                .findAny();

        firstOfficeProduct.ifPresent(System.out::println);

        //in case you just want whether filter criteria element is present in the stream or not

        boolean foundOfficeProduct = products.stream()
                .anyMatch(product -> product.getCategory() == Category.OFFICE);

        System.out.println("Does the list contains at least one office product : " + foundOfficeProduct);

        BigDecimal priceLimit = new BigDecimal("10.00");
        boolean allCheapProducts = products.stream()
                .allMatch(product -> product.getPrice().compareTo(priceLimit) < 0);

        System.out.println("Are all products cheap : " + allCheapProducts);

        boolean allExpensiveProducts = products.stream()
                .noneMatch(product -> product.getPrice().compareTo(priceLimit) < 0);

        System.out.println("Are all products expensive : " + allExpensiveProducts);

    }
}
