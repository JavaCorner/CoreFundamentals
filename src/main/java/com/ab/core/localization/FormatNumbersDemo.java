package com.ab.core.localization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Arpit Bhardwaj
 *
 *
 */
public class FormatNumbersDemo {
    public static void main(String[] args) {
        double num = 32360.856974;

        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
        //NumberFormat nf = NumberFormat.getInstance(new Locale("fr", "FR"));

        nf.setMaximumFractionDigits(2);
        System.out.println("Number formatted for the Locale : " + nf.format(num));


        DecimalFormat df = new DecimalFormat("$#0.00");

        System.out.println("Number formatted using decimal format : : " + df.format(num));
    }
}
