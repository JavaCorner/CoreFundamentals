package com.ab.core.lambdastreams.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String name;
    private final Category category;
    private final BigDecimal price;

    public Product(Category category, String name, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && category == product.category && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-16s $ %6.2f", category, name, price);
    }
}
