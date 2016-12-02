package com.epam.uitest;

import com.epam.commons.Timer;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.uitest.surrounding.InitTests;
import com.epam.uitest.surrounding.DataProviders;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.*;
import static com.controls.pages.surrounding.enums.Preconditions.SPPAGE_OPENED;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class NavigationElementsTest extends InitTests {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "SearchFieldTest")
    public void searchFieldTest(String searchRequest) {
        header.searchField.isDisplayed();
        header.searchField.findAction(searchRequest);
        supportPage.checkOpened();
    }

    @Test
    public void paginatorNavTest() {
        isInState(SPPAGE_OPENED);
        pageNavigationLine.next();
        Timer.waitCondition(() -> WebSettings.getDriver().getCurrentUrl().equals(datesPage.url));
        Assert.areEquals(WebSettings.getDriver().getCurrentUrl(), datesPage.url, "Unexpected url");
        pageNavigationLine.previous();
        Timer.waitCondition(() -> WebSettings.getDriver().getCurrentUrl().equals(supportPage.url));
        Assert.areEquals(WebSettings.getDriver().getCurrentUrl(), supportPage.url, "Unexpected url");
        pageNavigationLine.first();
        pageNavigationLine.previous();
        Timer.waitCondition(() -> WebSettings.getDriver().getCurrentUrl().equals(contactPage.url + "#"));
        Assert.areEquals(WebSettings.getDriver().getCurrentUrl(), contactPage.url+"#", "Unexpected url");
        pageNavigationLine.last();
        pageNavigationLine.next();
        Timer.waitCondition(() -> WebSettings.getDriver().getCurrentUrl().equals(metalsColorsPage.url + "#"));
        Assert.areEquals(WebSettings.getDriver().getCurrentUrl(), metalsColorsPage.url + "#", "Unexpected url");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "MenuNavTest")
    public void sidebarNavTest(boolean mainSidebarMenu,WebPage page, int pageNumInSidebar) {
        sidebar.isDisplayed();
        if (!mainSidebarMenu)
            sidebar.sidebarMenu.select(3);
        sidebar.sidebarMenu.select(pageNumInSidebar);
        Timer.waitCondition(() -> WebSettings.getDriver().getCurrentUrl().equals(page.url));
        Assert.areEquals(WebSettings.getDriver().getCurrentUrl(), page.url, "Unexpected url");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "MenuNavTest")
    public void headerNavTest(boolean mainHeaderMenu, WebPage page, int pageNumInSidebar) {
        header.isDisplayed();
        if (!mainHeaderMenu)
            header.headerMenu.select(3);
        header.headerMenu.select(pageNumInSidebar);
        Timer.waitCondition(() -> WebSettings.getDriver().getCurrentUrl().equals(page.url));
        Assert.areEquals(WebSettings.getDriver().getCurrentUrl(), page.url, "Unexpected url");
    }
}
