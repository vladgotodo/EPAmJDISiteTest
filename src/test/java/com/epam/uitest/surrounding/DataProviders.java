package com.epam.uitest.surrounding;


import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "forMainLoginTest")
    public Object[][] forMainLoginTest() {
        return new Object[][]{{true, "epam", "1234"},
                {false, "1234", "epam"}};
    }

    @DataProvider(name = "forAllPageOpeningsAfterLogin")
    public Object[][] forAllPageOpeningsAfterLogin() {
        return new Object[][]{{"https://jdi-framework.github.io/tests/page1.htm"},
                {"https://jdi-framework.github.io/tests/page2.htm"}, {"https://jdi-framework.github.io/tests/page3.htm"},
                {"https://jdi-framework.github.io/tests/page4.htm"}, {"https://jdi-framework.github.io/tests/page5.htm"},
                {"https://jdi-framework.github.io/tests/page6.htm"}, {"https://jdi-framework.github.io/tests/page7.htm"},
                {"https://jdi-framework.github.io/tests/page8.htm"}};
    }

    @DataProvider(name = "forPage8Checkboxes")
    public Object[][] forPage8Checkboxes() {
        return new Object[][]{
                {true, false, false, false},
                {true, true, false, false},
                {true, true, true, false},
                {true, true, true, true}};
    }

    @DataProvider(name = "forPage8Radiobuttons")
    public Object[][] forPage8Radiobuttons() {
        return new Object[][]{
                {true, false, false, false},
                {false, true, false, false},
                {false, false, true, false},
                {false, false, false, true}};
    }
}