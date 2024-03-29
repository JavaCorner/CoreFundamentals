package com.ab.core.lambdastreams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Arpit Bhardwaj
 *
 * Reducing Streams
 *      At the end of stream pipeline, in terminal operation construct final result by combining stream elements some way.
 *      is designed for immutable reduction
 *
 * Collecting Streams
 *      reduces a stream into a mutable result container
 *      is designed for mutable reduction
 *
 * An accumulator in a serial or parallel reduction should be associative and stateless.
 * In a parallel reduction, problematic accumulators tend to produce more visible errors.
 * 
 */
public class ReduceCollect {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        /********************Reduction*********************/

        //add prices of all
        //reduce takes accumulator(binary operator)
        Optional<BigDecimal> totalPrices1 = products.stream()
                .map(Product::getPrice)
                .reduce((result, currentElement) -> result.add(currentElement));

        Optional<BigDecimal> totalPrices2 = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add);

        //takes consumer and runnable(0 input,0 output)
        totalPrices2.ifPresentOrElse(
                total -> System.out.println("The total price of all products " + total),
                ()-> System.out.println("There are no products")
        );

        //takes identity (default value of final result) and accumulator(binary operator)
        BigDecimal totalPrices3 = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("The total price of all products " + totalPrices3);

        //takes identity (default value of final result) , accumulator(bi function), combiner(binary operator)
        //combiner is required mainly for parallel streams
        BigDecimal totalPrices4 = products.stream()
                .reduce(BigDecimal.ZERO, (result, product) -> result.add(product.getPrice()), BigDecimal::add);
        System.out.println("The total price of all products " + totalPrices4);


        /**
         * Collection takes supplier, accumulator(bi consumer), combiner(bi consumer)
         */

        //collecting product names in list using reduce method (inefficient)
        //as its immutable reduction, hence need to return the new list inside accumulator and combiner
        List<String> productNames1 = products.stream()
                .reduce(new ArrayList<>(),
                        (list, product) -> {
                            ArrayList<String> newList = new ArrayList<>(list);
                            newList.add(product.getName());
                            return newList;
                        },
                        (list1, list2) -> {
                            ArrayList<String> newList = new ArrayList<>(list1);
                            newList.addAll(list2);
                            return newList;
                        }
                );
        //productNames1.forEach(System.out::println);

        //collecting product names in list using collect method (efficient)
        ArrayList<String> productNames2 = products.stream()
                .collect(ArrayList::new,
                        (list, product) -> list.add(product.getName()),
                        ArrayList::addAll);
        //productNames2.forEach(System.out::println);

        //using Collectors factory methods (which provides a combination of above functions(supplier/accumulator/combiner/finisher))
        List<String> collectFactory = products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());

        //collectFactory.forEach(System.out::println);

        //toMap accepts Key Mapper and Value Mapper and merge function in case key are duplicates
        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.toMap(
                        Product::getCategory,
                        Product::getPrice,
                        BigDecimal::add
                ));

        System.out.println(totalPerCategory);
    }
}
