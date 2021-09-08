package com.ab.core.lambdastreams;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Arpit Bhardwaj
 *
 */
public class GroupingPartitioning {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        //group products by category
        //groupingBy accepts classifier
        Map<Category, List<Product>> productByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        for (Map.Entry entry:
                productByCategory.entrySet()) {
            //System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //group products name by category
        //groupingBy accepts classifier and downstream collector
        //mapping accepts mapper and downstream and collector
        Map<Category, List<String>> productNameByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.mapping(Product::getName,
                                Collectors.toList())));

        for (Map.Entry entry:
             productNameByCategory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        BigDecimal priceLimit = new BigDecimal("5.00");

        //partition by accepts predicate
        Map<Boolean, List<Product>> cheapExpensiveProducts = products.stream()
                .collect(Collectors.partitioningBy(product -> product.getPrice().compareTo(priceLimit) < 0));


        /*System.out.println("Cheap Products : ");
        cheapExpensiveProducts.get(true).forEach(System.out::println);

        System.out.println("Expensive Products : ");
        cheapExpensiveProducts.get(false).forEach(System.out::println);*/

        //partition by accepts predicate and downstream collector
        Map<Boolean, List<String>> cheapExpensiveProductsName = products.stream()
                .collect(Collectors.partitioningBy(
                        product -> product.getPrice().compareTo(priceLimit) < 0,
                        Collectors.mapping(Product::getName,
                                Collectors.toList())));

        System.out.println("Cheap Products : ");
        System.out.println(cheapExpensiveProductsName.get(true));

        System.out.println("Expensive Products : ");
        System.out.println(cheapExpensiveProductsName.get(false));

    }
}
