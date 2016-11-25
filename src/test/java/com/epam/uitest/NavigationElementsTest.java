package com.epam.uitest;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.uitest.surrounding.InitTests;
import com.epam.uitest.surrounding.dataproviders.DataProviders;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.controls.JDITestSite.*;
import static com.controls.pages.surrounding.Preconditions.SPPAGE_OPENED;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class NavigationElementsTest extends InitTests {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "SearchFieldTest")
    public void searchFieldTest(String searchRequest) {
        header.searchField.findAction(searchRequest);
    }

    @Test()
    public void navigationTest() {
        isInState(SPPAGE_OPENED);
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
