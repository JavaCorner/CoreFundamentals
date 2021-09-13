package com.ab.core.localization;

import java.util.Locale;

import static java.util.Locale.CANADA;
import static java.util.Locale.ITALIAN;

/**
 * @author Arpit Bhardwaj
 *
 * Oracle defines a locale as a geographical, political, or cultural region.
 */
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

        Locale frLocale = new Locale.Builder()
                .setLanguage("fr")
                .setRegion("FR")
                .setVariant("")
                .build();
        displayLocaleAttributes(frLocale);

        System.out.println("********Predefined Locale********");
        displayLocaleAttributes(CANADA);
        displayLocaleAttributes(ITALIAN);

        Locale.setDefault(new Locale("is", "IS"));
        displayLocaleAttributes(Locale.getDefault());
    }

    static void displayLocaleAttributes(Locale locale){
        System.out.println("********Displaying Locale Attributes********");
        System.out.println("Locale: " + locale.getDisplayName() + " (" +locale+")");
        System.out.println("Country: " + locale.getDisplayCountry() + " (" +locale.getCountry()+ ")");
        System.out.println("Language: " + locale.getDisplayLanguage() + " (" +locale.getLanguage()+ ")");
        System.out.println("Variant: " + locale.getDisplayVariant() + " (" +locale.getVariant()+ ")");
    }
}
