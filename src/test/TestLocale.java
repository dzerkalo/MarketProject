package test;

import java.util.Locale;

/**
 * Created by test on 08.11.15.
 */
public class TestLocale {

    public static void main(String[] args) {
        Locale currentLocale = Locale.getDefault();
        System.out.println(currentLocale.getLanguage());

    }
}
