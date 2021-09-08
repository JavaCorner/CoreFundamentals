package com.ab.core.localization;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Arpit Bhardwaj
 *
 * Resource bundles contain localizable resouces
 * resources bundles can be represented as plain text with extension .properties
 * ResourceBundle class loads and retrieves resources
 *
 */
public class ResourceBundleDemo {
    public static void main(String[] args) {
        printLocaleSpecific(Locale.CHINA);
        printLocaleSpecific(Locale.FRANCE);
    }

    public static void printLocaleSpecific(Locale localeFR){
        String name = "Cookie";
        BigDecimal price = BigDecimal.valueOf(2.99);
        LocalDate bestBefore = LocalDate.of(2021, Month.DECEMBER,1);
        int quantity = 4;

        ResourceBundle bundleFR = ResourceBundle.getBundle("messages", localeFR);
        String helloFR = bundleFR.getString("hello");
        System.out.println(helloFR);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localeFR);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(localeFR);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM YYYY", localeFR);

        String fPrice = currencyFormat.format(price);
        String fQuantity = numberFormat.format(quantity);
        String fBestBefore = dateTimeFormatter.format(bestBefore);

        String pattern = bundleFR.getString("product");
        System.out.println(MessageFormat.format(pattern,fPrice,fQuantity,fBestBefore));
    }
}
