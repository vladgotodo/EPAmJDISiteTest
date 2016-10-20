package com.epam.uitest;

import com.epam.controls.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
    private final String URL_START_PAGE= "https://jdi-framework.github.io/tests/index.htm";
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL_START_PAGE);
    }

    @AfterMethod
    public void afterMethod() {
        try {
            driver.quit();
        }
        catch (UnreachableBrowserException e) {
            System.out.println(e);
        }
    }

    @Test(groups = "Login", dataProviderClass = DataProvidersForMainLoginTest.class, dataProvider = "forMainLoginTest")
    public void loginMain(String userLogin, String userPassword){
        StartPage startPage = new StartPage(driver);
        startPage.loginAs(userLogin, userPassword);
    }

    @Test(groups = "Login", dataProviderClass = DataProvidersForMainLoginTest.class, dataProvider = "forAllPageOpeningsAfterLogin")
    public void allPageOpeningsAfterLogin(String url){
        StartPage startPage = new StartPage(driver);
        startPage.loginAs("epam", "1234");
        driver.navigate().to(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
