package com.epam.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StartPage {
    private WebDriver driver;

    private static String URL_START_PAGE = "https://jdi-framework.github.io/tests/index.htm";

    @FindBy(className = "profile-photo")
    @CacheLookup
    private WebElement profileMenu;

    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginFormElement;

    @FindBy(id = "Password")
    @CacheLookup
    private WebElement passwordFormElement;

    @FindBy(className = "btn-login")
    @CacheLookup
    private WebElement buttonLogin;

    @FindBy(className = "logout")
    @CacheLookup
    public WebElement buttonLogout;


    public StartPage(WebDriver driver) {
        if (!URL_START_PAGE.equals(driver.getCurrentUrl())) {
            throw new IllegalStateException("This is not the start page");
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void typeUsername(String username) {
        loginFormElement.click();
        loginFormElement.sendKeys(username);
    }

    private void typePassword(String password) {
        passwordFormElement.click();
        passwordFormElement.sendKeys(password);
    }

    private void submitLogin() {
        buttonLogin.click();
    }

    private void submitLogout() {
        buttonLogout.click();
    }

    public void loginAs(String username, String password) {
        profileMenu.click();
        typeUsername(username);
        typePassword(password);
        submitLogin();
        Assert.assertEquals(buttonLogout.getCssValue("display"), "block");
    }

    public void logout(){
        submitLogout();
    }
}
