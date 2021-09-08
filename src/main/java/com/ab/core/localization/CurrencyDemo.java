package com.ab.core.localization;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * @author Arpit Bhardwaj
 *
 *
 */
public class CurrencyDemo {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        //Locale locale = new Locale("hi","IN");
        LocaleDemo.displayLocaleAttributes(locale);

        Currency currency = Currency.getInstance(locale);
        System.out.println("********Displaying Currency Attributes********");
        System.out.println(currency.getDisplayName());
        System.out.println(currency.getSymbol());

        Double amount = 54628.7;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println(numberFormat.format(amount));
    }


}
