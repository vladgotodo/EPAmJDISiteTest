package com.epam.uitest.surrounding.dataproviders;

import com.controls.pages.surrounding.fillingTypes.ContactFormType;
import com.controls.pages.surrounding.fillingTypes.Plate;
import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "SearchFieldTest")
    public static Object[][] searchFieldTest() {
        return new Object[][]{{"123456"},
            {"asdfghjkl"}, {"фывапролд"}};
    }

    @DataProvider(name = "MetalsColorsTest")
    public static Object[][] metalsColorsTest() {
        return new Plate[][]{
                {new Plate("1","2",new String[]{"Water", "Earth"},"Green", "Gold",
                        new String[]{"Cucumber", "Tomato", "Onion"})},
                {new Plate("3","4",new String[]{"Earth", "Wind"},"Red", "Silver",
                        new String[]{"Tomato", "Onion"})},
                {new Plate("5","6",new String[]{"Water", "Fire"},"Yellow", "Bronze",
                        new String[]{"Cucumber", "Tomato"})},
                {new Plate("7","8",new String[]{"Wind", "Fire"},"Blue", "Selen",
                        new String[]{"Cucumber", "Tomato", "Onion", "Salad"})}};
    }

    @DataProvider(name = "ContactFormTest")
    public static Object[][] contactFormTest() {
        return new ContactFormType[][]{
                {new ContactFormType("7","8", "Green", "Gold", "afgdkgfdlgn")},
                {new ContactFormType("7","8","Red", "Silver", "aasdasdfgdhf")},
                {new ContactFormType("7","8","Yellow", "Bronze", "qwertghjj")},
                {new ContactFormType("7","8","Blue", "Selen","erghtbtgdnhgf")}};
    }
}
