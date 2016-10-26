package com.epam.controls.pages;

import com.epam.controls.pages.surrounding.BasePage;
import com.epam.controls.pages.surrounding.pageBlocks.LoginMenu;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage {
    private static final String URL_PAGE = "https://jdi-framework.github.io/tests/index.htm";
    public LoginMenu menu;

    public StartPage(WebDriver driver) {
        super(driver);
        driverS = driver;
        menu = new LoginMenu();
    }

    public void open(){
        driverS.navigate().to(URL_PAGE);
    }
}
