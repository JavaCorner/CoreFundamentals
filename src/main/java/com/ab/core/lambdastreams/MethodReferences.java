package com.ab.core.lambdastreams;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @author Arpit Bhardwaj
 *
 * Method reference
 *      are useful if you want to omit the extra method call of lambda
 *      whatever method you are going to call using method reference approach should be semantically identical to the method that lamdba expression is implementing
 *      are just shorthand of lambda nothing else.
 *
 * Method Reference can refer to:
 *      Reference a static method
 *          <class>::<static method>
 *      Reference a instance method of a particular object
 *          <object>::<instance method>
 *      Reference a instance method of an arbitrary object of a particular type
 *          <class>::<instance method>
 *      Reference a constructor
 *          <class>::new
 *
 */
public class MethodReferences {

    interface ProductFactory {
        Product create(Category category, String name, BigDecimal price);
    }
    static boolean isExpensive(Product product){
        return product.getPrice().compareTo(new BigDecimal("5.00")) >= 0;
    }
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        //here there are 2 layers - first lambda which in turns calls a single instance method
        //products.forEach(product -> System.out.println(product));

        //we can avoid extra lambda layer by using method reference
        //only restriction is the for each accepts consumer whose accept method must match with println in signature

        //referring to static method
        //removeIf accepts predicate whose test method should match with isExpensive which we are going to use as method reference
        //products.removeIf(MethodReferences::isExpensive);//throws UnsupportedOperationException as asList produces semi immutable list

        //referring to instance method
        products.forEach(System.out::println);
        //products.stream().map(Product::getName).forEach(System.out::println);

        //referring to constructor
        ProductFactory factory = Product::new;
        System.out.println(factory.create(Category.FOOD, "Blueberries", new BigDecimal("6.95")));

        //some standard examples
        UnaryOperator<String> toUpperCase1 = x->x.toUpperCase();
        UnaryOperator<String> toUpperCase2 = String::toUpperCase;

        String city = "Munich";
        Supplier<String> cityUpperCase = city::toUpperCase;
        System.out.println(cityUpperCase.get());

        String city2 = "Munich";
        Function<Locale,String> cityUpperCase2 = city::toUpperCase;
        System.out.println(cityUpperCase2.apply(Locale.GERMANY));

        Planet earth = new Planet("93000000");
        Function<BigDecimal,BigDecimal> l = Planet::milesToKilometers;
        System.out.println(l.apply(earth.getMilesFromSun()));
    }
    static public class Planet {
        private BigDecimal milesFromSun;
        public Planet(String milesFromSun){
            this.milesFromSun = new BigDecimal(milesFromSun);
        }
        public BigDecimal getMilesFromSun(){
            return milesFromSun;
        }
        public static BigDecimal milesToKilometers(BigDecimal miles){
            BigDecimal scale = new BigDecimal("1.60934");
            return miles.multiply(scale);
        }
    }
}
