package com.epam.uitest;


import org.testng.annotations.DataProvider;

public class DataProvidersForMainLoginTest {

    @DataProvider(name = "forMainLoginTest")
    public Object[][] forMainLoginTest() {
        return new Object[][]{{"epam", "1234"},
                {"1234", "epam"}};
    }

    @DataProvider(name = "forAllPageOpeningsAfterLogin")
    public Object[][] forAllPageOpeningsAfterLogin() {
        return new Object[][]{{"https://jdi-framework.github.io/tests/page1.htm"},
                {"https://jdi-framework.github.io/tests/page2.htm"}, {"https://jdi-framework.github.io/tests/page3.htm"},
                {"https://jdi-framework.github.io/tests/page4.htm"}, {"https://jdi-framework.github.io/tests/page5.htm"},
                {"https://jdi-framework.github.io/tests/page6.htm"}, {"https://jdi-framework.github.io/tests/page7.htm"},
                {"https://jdi-framework.github.io/tests/page8.htm"}};
    }
}