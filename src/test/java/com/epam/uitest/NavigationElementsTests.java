package com.epam.uitest;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.uitest.surrounding.InitTests;
import com.epam.uitest.surrounding.dataproviders.DataProviders;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.*;

public class NavigationElementsTests extends InitTests {

    @Test(groups = "SearchField", dataProviderClass = DataProviders.class, dataProvider = "SearchFieldTest")
    public void searchFieldTest(String searchRequest) {
        header.searchField.findAction(searchRequest);
        supportPage.checkOpened();
    }

    @Test(groups = "Navigation")
    public void navigationTest() {
        supportPage.open();
        supportPage.checkOpened();
        pageNavigationLine.next();
        datesPage.checkOpened();
        pageNavigationLine.previous();
        supportPage.checkOpened();
        pageNavigationLine.first();
        pageNavigationLine.previous();
        Assert.contains(WebPage.getUrl(),"page1");
        //contactPage.checkOpened();
        pageNavigationLine.last();
        pageNavigationLine.next();
        Assert.contains(WebPage.getUrl(),"page2");
        //metalsColorsPage.checkOpened();
    }
}
