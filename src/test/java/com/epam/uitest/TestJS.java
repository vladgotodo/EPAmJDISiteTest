package com.epam.uitest;

import com.epam.controls.pages.StartPage;
import com.epam.uitest.surrounding.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestJS extends BaseTest{
    @BeforeMethod
    public void thisPageSetup(){
        StartPage startPage = new StartPage(driver);
        startPage.open();
    }

    @Test(groups = "JavaScript")
    public void handleJavaScript(){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("alert('ALERT!');");
        }
        catch (Exception e){
            System.out.println(e);
        }
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Alert alert = driver.switchTo().alert();
        verify("ALERT!",alert.getText());
        alert.accept();
    }
}
