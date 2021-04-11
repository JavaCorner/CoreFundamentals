package com.ab.core.localization;

import java.util.Locale;

import static java.util.Locale.CANADA;
import static java.util.Locale.ITALIAN;

public class LocaleDemo {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        displayLocaleAttributes(locale);

        Locale inLocaleA = new Locale("hi");
        displayLocaleAttributes(inLocaleA);
        Locale inLocaleB = new Locale("hi", "IN");
        displayLocaleAttributes(inLocaleB);
        Locale inLocaleC = new Locale("hi", "IN", "WIN");
        displayLocaleAttributes(inLocaleC);

        Locale frLocale = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
        displayLocaleAttributes(frLocale);

        System.out.println("********Displaying Locale Constants Attributes********");
        System.out.println("Country: " + CANADA.getDisplayCountry());
        System.out.println("Language: " + ITALIAN.getDisplayLanguage());
    }

    static void displayLocaleAttributes(Locale locale){
        System.out.println("********Displaying Locale Attributes********");

        System.out.println("Locale Name: " + locale.getDisplayName());

        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: " + locale.getDisplayLanguage());
        System.out.println("Variant: " + locale.getDisplayVariant());

        System.out.println("Country Code: " + locale.getCountry());
        System.out.println("Language Code: " + locale.getLanguage());
        System.out.println("Variant Code: " + locale.getVariant());
    }
}
