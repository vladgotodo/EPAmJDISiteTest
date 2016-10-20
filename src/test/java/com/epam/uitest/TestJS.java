package com.epam.uitest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestJS {
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

    @Test(groups = "JavaScript")
    public void handleJavaScript(){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('ALERT!');");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("ALERT!",alert.getText());
        alert.accept();
    }
}
