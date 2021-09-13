package com.ab.core.lambdastreams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntBiFunction;

/**
 * @author Arpit Bhardwaj
 *
 * A lambda expression is an anonymous method
 * it will be passed as a code to other method
 *
 * A Lambda expression implements a functional interface
 * {}, return keyword and ; is optional in case one line simple statement
 * () are optional in case of single parameter
 *
 */
public class LambdaExpression {
    String msg = "Hello";

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        //Anonymous Inner Class
        /*products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getPrice().compareTo(p2.getPrice());
            }
        });*/

        //Lambda Expression
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

        IntBinaryOperator intBinaryOperator = (p, q) -> p + q;
        ToIntBiFunction<Integer, Integer> toIntBiFunction = (Integer x, Integer y) -> x * y;
        BiFunction biFunction = (left,right) -> {
            return "null";
        };
        wouldNotCompile();

        var list = new ArrayList<>();
        list.add("Jan");
        //list.add(String::new);
    }

    private static void wouldNotCompile() {
        //incompatible parameter types
        //ToIntBiFunction<Integer, Integer> f1 = (int x,int y) -> x+y;

        //cannot mix implicitly and explicitly typed parameters
        //ToIntBiFunction<Integer, Integer> f2 = (Integer x, y) -> x+y;

        //cannot mix var and non-var implicitly typed parameters
        //ToIntBiFunction<Integer, Integer> f3 = (var x, y) -> x+y;

        //cannot mix var and non-var explicitly typed parameters
        //ToIntBiFunction<Integer, Integer> f4 = (Integer x, var y) -> x+y;

        //cannot omit parenthesis for single explicitly typed or var parameters
        //Function<Integer, Integer> f4 = var x -> x++;
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
