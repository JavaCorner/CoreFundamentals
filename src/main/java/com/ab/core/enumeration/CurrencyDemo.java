package com.ab.core.enumeration;

/**
 * @author Arpit Bhardwaj
 *
 */
public class CurrencyDemo {
    public static void main(String[] args) {
        Currency currency = Currency.NICKLE;//this calls enum constructor internally to form NICKLE with value 2 which an instance of enum
        // currency = 1;
        System.out.println(currency);
        System.out.println(Currency.DIME.color());

        //iterate over values of Enum in order of definition
        for (Currency curr: Currency.values()) {
            System.out.println("Coin: " + curr);
        }
    }
}
