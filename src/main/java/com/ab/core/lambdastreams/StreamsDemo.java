package com.ab.core.lambdastreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Arpit Bhardwaj
 *
 * Streams may or may not produce elements in specific order
 * List is an ordered collection, hence stream on it produce ordered elements
 * Set is an unordered collection, hence stream on it produce unordered elements
 *
 * BaseStream (Interface)
 *      Stream (Interface)
 *      IntStream (Interface)
 *      LongStream (Interface)
 *      DoubleStream (Interface)
 *
 * Methods in BaseStream Interface
 *      sequential
 *      parallel
 *      isParallel
 *      unordered
 * Methods in Stream Interface
 *      Intermediate Operation:
 *          filter
 *          map,flatmap
 *          peek,distinct,sorted,skip,limit
 *          dropWhile,takeWhile
 *      Terminal Operation:
 *          forEach,forEachOrdered
 *          count,min,max,sum,average : return values
 *          collect,reduce
 *          allMatch,anyMatch,NoneMatch,findAny,findFirst : return Optional object
 *
 * Differences:
 *      forEach,forEachOrdered:
 *          forEach operation doesn't gurantee the order of elements, which is actually beneficial for parallel stream
 *      map,flatMap:
 *          map stream elements to a new stream of different content type
 *          flatMap flatten a number of streams to a single stream
 *      dropWhile,takeWhile:
 *          takeWhile() accepts all values until predicate returns false
 *          dropWhile() drops all values until it matches the predicate
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

        //obtaining streams from collection.
        Stream<Product> productStream1 = products.stream();

        //obtaining streams from array
        String[] strings = new String[]{"one","two","three"};
        Stream<String> stream0 = Arrays.stream(strings);

        //obtaining streams from static methods of Stream
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
                .filter(product -> product.getCategory() == Category.FOOD)
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

        //The Optional class has
        // isPresent() method that doesn't take any parameter and returns a boolean and is commonly used in if statements.
        // ifPresent() method that takes a consumer parameter and runs it only if the Optional is nonempty.
        firstOfficeProduct.ifPresent(System.out::println);

        //in case the stream produce unordered elements then findFirst and findAny has no difference
        //in case the stream produce ordered elements then findFirst element which first match the filter criteria and findAny return any random match
        Optional<Product> anyOfficeProduct = products.stream()
                .filter(product -> product.getCategory() == Category.OFFICE)
                .findAny();

        firstOfficeProduct.ifPresent(System.out::println);

        //in case you just want whether filter criteria element is present in the stream or not
        //use anyMatch, allMatch, noneMatch and all takes predicate

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


        Stream.of("India", "Australia", "New Zealand", "", "South Africa", "England")
                .takeWhile(o->!o.isEmpty())
                .forEach(System.out::print);
        System.out.println();

        Stream.of("India", "Australia", "New Zealand", "", "England", "Srilanka")
                .dropWhile(o->!o.isEmpty())
                .forEach(System.out::print);

        //Perform actions on stream pipeline elements
        //combine consumers
        //Default addThen Method of Consumer Interface combines consumer together
        Consumer<Product> expireProduct = p -> p.setBestBefore(LocalDate.now());
        Consumer<Product> discountProduct = p -> p.setDiscount(BigDecimal.valueOf(0.1));

        products.stream().forEach(expireProduct.andThen(discountProduct));

        products.stream().peek(expireProduct)
                .filter(p->p.getPrice().compareTo(BigDecimal.valueOf(10))>0)
                .forEach(discountProduct);

        //Perform filtering on stream pipeline elements
        //combine filtering
        Predicate<Product> foodFilter = p -> p.getCategory().equals(Category.FOOD);
        Predicate<Product> priceFilter = p -> p.getPrice().compareTo(BigDecimal.valueOf(2)) < 0;

        products.stream().filter(foodFilter.negate().or(priceFilter))   // !foodFilter || priceFilter
                .forEach(discountProduct);

        //Perform mapping on stream pipeline elements
        //combine functions
        //Default addThen Method of Function Interface combines functions together
        Function<Product,String> nameMapper = p -> p.getName();
        UnaryOperator<String> trimMapper = p -> p.trim();
        ToIntFunction<String> lengthMapper = p -> p.length();

        products.stream()
                .map(nameMapper.andThen(trimMapper))
                .mapToInt(lengthMapper)
                .sum();


    }
}
