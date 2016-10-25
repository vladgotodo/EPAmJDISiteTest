package com.epam.controls.pages.surrounding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public static WebDriver driverS;

    public BasePage(WebDriver driver, String pageUrl) {
        if (!pageUrl.equals(driver.getCurrentUrl())) {
            throw new IllegalStateException("This is not the start page");
        }

        PageFactory.initElements(driver, this);
        driverS = driver;
    }
}
