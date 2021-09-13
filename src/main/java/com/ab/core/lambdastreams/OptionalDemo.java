package com.ab.core.lambdastreams;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.ab.core.lambdastreams.Category.FOOD;
import static com.ab.core.lambdastreams.Category.OFFICE;

public class OptionalDemo {
    public static void main(String[] args) {
        Product dummyProduct = new Product(OFFICE, "Dummy", new BigDecimal("0"));

        List<Product> products = ExampleData.getProducts();

        Optional<Product> firstOfficeProduct = products.stream()
                .filter(product -> product.getCategory() == Category.OFFICE)
                .findFirst();

        //get() returns the value if present, otherwise throws NoSuchElementException.
        Product product = firstOfficeProduct.isPresent() ? firstOfficeProduct.get() : dummyProduct;

        // isPresent() method that doesn't take any parameter and returns a boolean and is commonly used in if statements.
        // ifPresent() method that takes a consumer parameter and runs it only if the Optional is nonempty.
        firstOfficeProduct.ifPresent(System.out::println);

        //orElse() Returns the value if present, otherwise returns other.
        //orElseGet(supplier) Returns the value if present, otherwise invokes supplier.
        //orElseThrow() Returns the value if present, otherwise throws an exception to be created by the provided supplier.
        //orElseThrow(exceptionSupplier) Returns the value if present, otherwise invokes exception supplier.
        firstOfficeProduct.orElse(dummyProduct);
        firstOfficeProduct.orElseGet(()-> dummyProduct);
        firstOfficeProduct.orElseThrow();
        firstOfficeProduct.orElseThrow(RuntimeException::new);

        firstOfficeProduct.ifPresentOrElse(System.out::println,()-> System.out.println(dummyProduct));
    }
}
