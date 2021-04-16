package com.ab.core.lambdastreams;

import com.ab.core.lambdastreams.model.Category;
import com.ab.core.lambdastreams.model.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Arpit Bhardwaj
 *
 *
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

        products.stream()
                .filter(product -> product.getCategory()== Category.FOOD)
                .forEach(System.out::println);

        products.stream()
                .map(product -> String.format("The price of %s is $ %.2f",product.getName(),product.getPrice()))
                .forEach(System.out::println);

        products.stream()
                .flatMap(product -> Pattern.compile("\\s").splitAsStream(product.getName()))
                .forEach(System.out::println);

    }
}
