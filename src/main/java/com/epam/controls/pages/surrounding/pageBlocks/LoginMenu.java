package com.epam.controls.pages.surrounding.pageBlocks;

import com.epam.controls.pages.Page8;
import com.epam.controls.pages.StartPage;
import com.epam.controls.pages.surrounding.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMenu {
    private WebDriver driver;

    @FindBy(className = "navbar-right")
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
        new WebDriverWait(StartPage.driverS, 30).until(ExpectedConditions.visibilityOfElementLocated(By.className("navbar-right")));
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
