package com.ab.core.lambda;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionSyntax {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        /*products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getPrice().compareTo(p2.getPrice());
            }
        });*/

        /*products.sort((Product p1, Product p2) -> {
            return p1.getPrice().compareTo(p2.getPrice());
        });*/

        //products.sort((Product p1, Product p2) -> p1.getPrice().compareTo(p2.getPrice()));

        /*products.sort((p1, p2) -> {
            return p1.getPrice().compareTo(p2.getPrice());
        });*/

        products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

        for (Product p:
             products) {
            System.out.println(p);
        }
    }
}
