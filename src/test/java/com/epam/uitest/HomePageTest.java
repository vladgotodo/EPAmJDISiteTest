package com.epam.uitest;

import com.controls.pages.surrounding.entities.User;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.uitest.surrounding.DataProviders;
import com.epam.uitest.surrounding.InitTestWithoutLogin;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.*;
import static com.controls.pages.surrounding.enums.Preconditions.*;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class HomePageTest extends InitTestWithoutLogin {

    @BeforeTest
    public static void setUpBeforeTests() {
        isInState(HOMEPAGE_OPENED);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "UserLogin")
    public void loginTest(boolean valid, User user) {
        login.submit(user);
        Assert.assertEquals(login.logout.isDisplayed(), valid, "Unexpected login result");
        if (!valid)
            login.profile.click();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "AccessTest")
    public void accessTest(boolean valid, WebPage page, User user) {
        Assert.assertEquals(header.isDisplayed(), true, "Header is not displayed");
        Assert.assertEquals(footer.isDisplayed(), true, "Footer is not displayed");
        Assert.assertEquals(sidebar.isDisplayed(), true, "Sidebar is not displayed");
        login.submit(user);
        page.open();
        if (valid) {
            Assert.assertEquals(WebSettings.getDriver().getCurrentUrl(), page.url, "Unexpected login result");
            isInState(LOGOUT_BTN);
            isInState(LOGOUT);
        }
        else
            Assert.assertEquals(WebSettings.getDriver().getCurrentUrl(), homePage.url, "Unexpected login result");
    }
}
