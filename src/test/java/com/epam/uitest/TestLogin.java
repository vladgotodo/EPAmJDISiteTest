package com.epam.uitest;

import com.epam.controls.pages.StartPage;
import com.epam.uitest.surrounding.BaseTest;
import com.epam.uitest.surrounding.DataProviders;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestLogin extends BaseTest{
    StartPage startPage;

    @BeforeMethod
    public void thisPageSetup(){
        startPage = new StartPage(driver);
        startPage.open();
    }

    @Test(groups = "Login", dataProviderClass = DataProviders.class, dataProvider = "forMainLoginTest")
    public void loginMain(boolean isTestPositive, String userLogin, String userPassword){
        try {
            startPage.menu.clickMenu();
        }
        catch (ElementNotVisibleException e){
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("C:\\tmp\\screenshot.png"));
            } catch (IOException e1) {
                System.out.println(e1);
            }
        }
        startPage.menu.typeUsername(userLogin).
                typePassword(userPassword).
                submitLogin();
        if(isTestPositive)
            verify(startPage.menu.buttonLogout.getCssValue("display"), "block");
        else
            verify(startPage.menu.buttonLogout.getCssValue("display"), "none");
    }

    @Test(groups = "Login", dataProviderClass = DataProviders.class, dataProvider = "forAllPageOpeningsAfterLogin")
    public void allPageOpeningsAfterLogin(String url){
        startPage.menu.clickMenu().
                typeUsername("epam").
                typePassword("1234").
                submitLogin();
        openSite(url);
        verify(driver.getCurrentUrl(), url);
    }
}
