package com.epam.uitest.surrounding;

import com.controls.JDITestSite;
import com.controls.pages.surrounding.other.User;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.*;

import static com.controls.JDITestSite.login;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.controls.JDITestSite.homePage;

public class InitTests extends TestNGBase {
    @BeforeMethod(alwaysRun = true)
    public static void setUpBeforeSuite() throws Exception {
        WebSite.init(JDITestSite.class);
        homePage.open();
        homePage.checkOpened();
        login.submit(User.DEFAULT);
        Verify.getFails();
        logger.info("Run Tests");
    }

    @AfterMethod
    public void tearDownAfterMethod() {
        Verify.getFails();
        WebSettings.getDriverFactory().close();
    }
}
