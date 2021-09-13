package com.ab.core.localization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * @author Arpit Bhardwaj
 *
 *
 */
public class FormatNumbersDemo {
    public static void main(String[] args) {
        double num = 32360.856974;

        NumberFormat nf = NumberFormat.getInstance(Locale.CHINA);
        NumberFormat cf = NumberFormat.getCurrencyInstance();

        nf.setMaximumFractionDigits(2);
        System.out.println("Number formatted for the Locale : " + nf.format(num));
        System.out.println("Number formatted for the Locale : " + cf.format(num));

        DecimalFormat df = new DecimalFormat("$#0.00");
        System.out.println("Number formatted using decimal format : : " + df.format(num));

        String pattern = "#,00.#";
        var message = DoubleStream.of(2.1, 6.923, 1000)
                .mapToObj(v -> new DecimalFormat(pattern).format(v))
                .collect(Collectors.joining("> <"));
        System.out.print("<" + message + ">");
    }
}
