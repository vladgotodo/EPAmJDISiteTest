package com.epam.controls.pages.surrounding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public static WebDriver driverS;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driverS = driver;
    }
}
