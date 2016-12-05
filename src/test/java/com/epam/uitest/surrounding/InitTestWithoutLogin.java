package com.epam.uitest.surrounding;

import com.controls.JDITestSite;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class InitTestWithoutLogin extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUpBeforeSuite() throws Exception {
        //WebSettings.useDriver(System.getProperty("browser"));
        //WebSettings.useDriver("Firefox");
        WebSettings.useDriver("chrome");
        WebSite.init(JDITestSite.class);
        Verify.getFails();
        logger.info("Run Tests----------------------------------------------");
    }

    @AfterSuite
    public void tearDownAfterSuite() {
        Verify.getFails();
        WebSettings.getDriver().quit();
    }
}