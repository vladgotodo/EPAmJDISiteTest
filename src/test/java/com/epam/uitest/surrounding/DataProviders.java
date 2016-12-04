package com.epam.uitest.surrounding;

import com.controls.pages.surrounding.entities.CFType;
import com.controls.pages.surrounding.entities.Plate;
import com.controls.pages.surrounding.entities.User;
import org.testng.annotations.DataProvider;

import static com.controls.JDITestSite.*;
import static com.epam.commons.Timer.nowTime;

public class DataProviders {
    @DataProvider(name = "SearchFieldTest")
    public static Object[][] searchFieldTestDP() {
        return new Object[][]{{"123456"},
            {"asdfghjkl"}, {"фывапролд"}
        };
    }

    @DataProvider(name = "UserLogin")
    public static Object[][] loginTestDP() {
        return new Object[][]{
                {false, new User("1234", "epam")},
                {false, new User("epamepam", "123456234")},
                {false, new User("epampampam", "1234")},
                {false, new User("epam", "0123")},
                {true, new User("epam", "1234", "Piter Chailovskii")}
        };
    }

    @DataProvider(name = "MetalsColorsTest")
    public static Object[][] metalsColorsTestDP() {
        return new Object[][]{
                {true, new Plate("1","2",new String[]{"Water", "Earth"},"Green", "Gold",
                        new String[]{"Cucumber", "Tomato", "Onion"})},
                {true, new Plate("3","4",new String[]{"Earth", "Wind"},"Red", "Silver",
                        new String[]{"Tomato", "Onion"})},
                {true, new Plate("5","6",new String[]{"Water", "Fire"},"Yellow", "Bronze",
                        new String[]{"Cucumber", "Tomato"})},
                {true, new Plate("7","8",new String[]{"Wind", "Fire"},"Blue", "Selen",
                        new String[]{"Cucumber", "Tomato", "Onion", "Salad"})},
                {false, new Plate("7","8",new String[]{"Wind", "Fire"},"Blue", "dnfgnGgdb",
                        new String[]{"Cucumber", "Tomato", "Onion", "Salad"})},
                {false, new Plate("7","8",new String[]{"Wind", "Fire"},"Blue", "+_)(*?:%~!@#$%^&*;№`1234567890-=",
                        new String[]{"Cucumber", "Tomato", "Onion", "Salad"})},
                {false, new Plate("7","8",new String[]{"Wind", "Fire"},"Blue", "Авапавипп",
                        new String[]{"Cucumber", "Tomato", "Onion", "Salad"})},
                {false, new Plate("7","8",new String[]{"Wind", "Fire"},"Blue", "erDhxbngvc",
                        new String[]{"Cucumber", "Tomato", "Onion", "Salad"})}
        };
    }

    @DataProvider(name = "DEPageElemetsTest")
    public static Object[][] depageElemetsTest() {
        return new Object[][]{
                {false, true, true, true, "Selen", "Blue"},
                {true, false, true, true, "Gold", "Red"},
                {true, true, false, true, "Silver", "Green"},
                {true, true, true, false, "Bronze", "Yellow"},
                {false, false, true, true, "Selen", "Blue"},
                {false, false, false, true, "Gold", "Red"},
                {false, false, false, false, "Silver", "Green"},
                {true, true, true, true, "Bronze", "Yellow"},
        };
    }

    @DataProvider(name = "ContactFormTest")
    public static Object[][] contactFormTestDP() {
        return new Object[][]{
                {new CFType("1", "2", "BoB", "Green", "afgdkg fdl gn")},
                {new CFType("3", "4", "Dilan", "SilveR", "кириллица русские слова")},
                {new CFType("5", "6", "Monika", "ФАМИЛИЯ на кИр", "кириллица руССкие СЛОВА")},
                {new CFType("7", "8", "ИМЯ на кИр", "ФАМИЛИЯ на кИр", "кириллица русские слова")},
                {new CFType("7", "8", "!@#$%^&*()_+1234567890-=", "!@#$%^&*()_+1234567890-=", "!@#$%^&*()_+1234567890-=")}
        };
    }

    //(boolean positiveTest, WebPage page, User user)

    @DataProvider(name = "AccessTest")
    public static Object[][] accessTestDP() {
        return new Object[][]{
                /*{false, contactPage, User.EMPTY},
                {false, metalsColorsPage, User.EMPTY},
                {false, supportPage, User.EMPTY},
                {false, datesPage, User.EMPTY},
                {false, simpleTablePage, User.EMPTY},
                {false, complexTablePage, User.EMPTY},
                {false, tablePagesPage, User.EMPTY},*/
                {true, contactPage, User.DEFAULT},
                {true, metalsColorsPage, User.DEFAULT},
                {true, supportPage, User.DEFAULT},
                {true, datesPage, User.DEFAULT},
                {true, simpleTablePage, User.DEFAULT},
                {true, complexTablePage, User.DEFAULT},
                {true, tablePagesPage, User.DEFAULT}
        };
    }

    @DataProvider(name = "MenuNavTest")
    public static Object[][] menuNavTestDP() {
        return new Object[][]{
                {true, contactPage, 2},
                {true, homePage, 1},
                {true, metalsColorsPage, 10},
                {false, supportPage, 4},
                {false, datesPage, 5},
                {false, complexTablePage, 6},
                {false, simpleTablePage, 7},
                {false, tablePagesPage, 8},
        };
    }

    @DataProvider(name = "RowsCountTablePageTest")
    public static Object[][] entriesDropdownTablePageTestDP() {
        return new Object[][]{
                {5},
                {10},
                {15},
                {20}
        };
    }

    @DataProvider(name = "SearchTablePageTest")
    public static Object[][] searchFieldTablePageTestDP() {
        return new Object[][]{
                {true, 2, 3, "linq"},
                {false, 1, 1, "asd"},
                {true, 2, 2, "ba"}
        };
    }

    @DataProvider(name = "SimpleTablePageTableTest")
    public static Object[][] simpleTablePageTableTestDP() {
        return new Object[][]{
                {1, 1, "Drivers"},
                {2, 2, "TestNG, JUnit, Custom"},
                {3, 3, "MSTest, NUnit, Epam"},
                {2, 4, "Log4J, TestNG log, Custom"},
                {1, 5, "Reporter"},
                {2, 6, "Custom"}
        };
    }

    @DataProvider(name = "RollersDatesPageTest")
    public static Object[][] rollersDatesPageTestDP() {
        return new Object[][]{
                {0, 100},
                {1, 99},
                {49, 51},
                {0, 0},
                {25, 25},
                {50, 50},
                {75, 75},
                {100, 100},
        };
    }

    @DataProvider(name = "RangeFieldsDatesPageTest")
    public static Object[][] rangeFieldsDatesPageTestDP() {
        return new Object[][]{
                {"0", "0"},
                {"1", "10000000000"},
                {"-1234567", "-098765432"},
                {"dfghjm,jbfgbvb", "snhmj,tdyh"},
                {"!@#$%~`^&*()_+!№;%:?*", "!@#$%~`^&*()_+!№;%:?*"},
                {"вап", "!@#$%~`^&*()_+!№;%:?*"},
                {"!@#$%~`^&*()_+!№;%:?*", "345"},
                {"110000000000", "0"}
        };
    }

    @DataProvider(name = "TimepickerFieldDatesPageTest")
    public static Object[][] timepickerFieldDatesPageTest() {
        return new Object[][]{
                {"0", "1:00 AM"},
                {"1", "1:00 AM"},
                {"-1234567", "12:34 AM"},
                {"dfghjm,jbfgbvb", "1:00 AM"},
                {"!@#$%~`^&*()_+!№;%:?*", "1:00 AM"},
                {"вап", "1:00 AM"},
                {"098765432", "9:59 AM"},
                {"5", "5:00 AM"},
                {"50", "12:00 AM"},
                {"11:11 AM", "11:11 AM"},
                {"12:12 PM", "12:12 PM"},
                {"13:40 AM", "12:40 AM"},
                {"14:40 PM", "12:40 PM"}
        };
    }

    @DataProvider(name = "DatepickerFieldDatesPageTest")
    public static Object[][] datepickerFieldDatesPageTest() {
        return new Object[][]{
                {nowTime("MM/dd/yyyy"), nowTime("MM/dd/yyyy")},
                {"11/25/1994", "11/25/1994"},
                {"-1234567", nowTime("MM/dd/yyyy")},
                {"dfghjm,jbfgbvb", nowTime("MM/dd/yyyy")},
                {"dfghjm,jbfgbvb,dfghjm,jbfgbvb,dfghjm,jbfgbvb", nowTime("MM/dd/yyyy")},
                {"!@#$%~`^&*()_+!№;%:?*", nowTime("MM/dd/yyyy")},
                {"вап", nowTime("MM/dd/yyyy")},
                {"098765432", nowTime("MM/dd/yyyy")},
                {"11.11.2000", "11/11/2000"},
                {"25.12.2000", "12/25/2000"},
                {"2012.11.11", "11/11/2012"}
        };
    }
}
