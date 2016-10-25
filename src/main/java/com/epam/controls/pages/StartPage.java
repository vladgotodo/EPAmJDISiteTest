package com.epam.controls.pages;

import com.epam.controls.pages.surrounding.BasePage;
import com.epam.controls.pages.surrounding.pageBlocks.LoginMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class StartPage extends BasePage {
    private static final String URL_PAGE = "https://jdi-framework.github.io/tests/index.htm";
    public LoginMenu menu;

    public StartPage(WebDriver driver) {
        super(driver, URL_PAGE);
        driverS = driver;
        menu = new LoginMenu();
    }
}
