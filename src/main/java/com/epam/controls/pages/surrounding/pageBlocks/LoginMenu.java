package com.epam.controls.pages.surrounding.pageBlocks;

import com.epam.controls.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMenu {
    private WebDriver driver;

    //@FindBy(className = "navbar-right")
    @FindBy(xpath = "html/body/div/header/div/nav/ul[2]")
    private WebElement profileMenu;

    @FindBy(id = "Login")
    private WebElement loginFormElement;

    @FindBy(id = "Password")
    private WebElement passwordFormElement;

    @FindBy(className = "btn-login")
    private WebElement buttonLogin;

    @FindBy(className = "logout")
    public WebElement buttonLogout;

    public LoginMenu() {
        driver = StartPage.driverS;
        PageFactory.initElements(driver, this);
    }

    public void submitLogin() {
        buttonLogin.click();
    }

    public LoginMenu clickMenu() {
        profileMenu.click();
        return this;
    }

    public LoginMenu typeUsername(String username) {
        loginFormElement.click();
        loginFormElement.sendKeys(username);
        return this;
    }

    public LoginMenu typePassword(String password) {
        passwordFormElement.click();
        passwordFormElement.sendKeys(password);
        return this;
    }

}
