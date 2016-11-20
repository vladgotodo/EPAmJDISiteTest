package com.epam.uitest.surrounding.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "SearchFieldTest")
    public Object[][] forMainLoginTest() {
        return new Object[][]{{"123456"},
            {"asdfghjkl"}, {"фывапролд"}};
    }
}
