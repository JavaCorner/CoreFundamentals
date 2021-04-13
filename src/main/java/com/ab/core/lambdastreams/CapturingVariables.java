package com.ab.core.lambdastreams;

import com.ab.core.lambdastreams.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Arpit Bhardwaj
 *
 * The captured vaiables in labda expression must be final or effectively final
 */
public class CapturingVariables {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        List<Product> cheapProducts = new ArrayList<>();
        BigDecimal priceLimit = new BigDecimal("5.00");
        //priceLimit = new BigDecimal("6.00");//will not be anymore effectively final//compile error in lambda line
        Predicate<Product> filterPredicateByPrice = p -> p.getPrice().compareTo(priceLimit) < 0;
        cheapProducts = filterProductsBasedOnPrice(products,filterPredicateByPrice);

        //below code may lead concurrent modification exception
        /*products.parallelStream().forEach(p -> {
            if(p.getPrice().compareTo(priceLimit) < 0){
                cheapProducts.add(p);
            }
        });*/
        //priceLimit = new BigDecimal("6.00");//not allowed even here

        cheapProducts.forEach(System.out::println);
    }

    private static List<Product> filterProductsBasedOnPrice(List<Product> products, Predicate<Product> filterPredicate) {
        List<Product> filterProducts = new ArrayList<>();
        for (Product product:
             products) {
            if (filterPredicate.test(product)){
                filterProducts.add(product);
            }
        }


        return filterProducts;
    }
}
