package com.ab.core.lambdastreams;

import com.ab.core.lambdastreams.model.Product;

import java.util.List;

/**
 * @author Arpit Bhardwaj
 *
 * A lambda expression is an anonymous method
 * it will be passed as a code to other method
 *
 * A Lambda expression implements a functional interface
 *
 *
 */
public class LambdaExpression {
    String msg = "Hello";

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

    public void printMessageAnonymous(){
        //in anonymous class this refers to instance of anonymous class
        Runnable runnable = new Runnable() {
            private String msg = "Hello";
            @Override
            public void run() {
                System.out.println(this.msg);
            }
        };

        new Thread(runnable).start();
    }

    public void printMessageLambda(){
        //in lambda this refers to instance of enclosing class
        Runnable runnable = () -> System.out.println(this.msg);
        new Thread(runnable).start();
    }
}
