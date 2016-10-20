package com.epam.uitest;

import com.epam.controls.Page8;
import com.epam.controls.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPage8 {
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

    @Test(groups = "page8")
    public void testPage8(){
        StartPage startPage = new StartPage(driver);
        startPage.loginAs("epam", "1234");
        driver.navigate().to("https://jdi-framework.github.io/tests/page8.htm");
        Page8 page8 = new Page8(driver);
        page8.waterCheckbox.check();
        Assert.assertEquals(page8.waterCheckbox.isChecked(), true);
        page8.earthCheckbox.check();
        Assert.assertEquals(page8.waterCheckbox.isChecked(), true);
        Assert.assertEquals(page8.earthCheckbox.isChecked(), true);
        page8.windCheckbox.check();
        Assert.assertEquals(page8.waterCheckbox.isChecked(), true);
        Assert.assertEquals(page8.earthCheckbox.isChecked(), true);
        Assert.assertEquals(page8.windCheckbox.isChecked(), true);
        page8.fireCheckbox.check();
        Assert.assertEquals(page8.waterCheckbox.isChecked(), true);
        Assert.assertEquals(page8.earthCheckbox.isChecked(), true);
        Assert.assertEquals(page8.windCheckbox.isChecked(), true);
        Assert.assertEquals(page8.fireCheckbox.isChecked(), true);
        page8.goldRadiobutton.check();
        Assert.assertEquals(page8.goldRadiobutton.isChecked(), true);
        page8.silverRadiobutton.check();
        Assert.assertEquals(page8.goldRadiobutton.isChecked(), false);
        Assert.assertEquals(page8.silverRadiobutton.isChecked(), true);
        page8.bronzeRadiobutton.check();
        Assert.assertEquals(page8.goldRadiobutton.isChecked(), false);
        Assert.assertEquals(page8.silverRadiobutton.isChecked(), false);
        Assert.assertEquals(page8.bronzeRadiobutton.isChecked(), true);
        page8.selenRadiobutton.check();
        Assert.assertEquals(page8.goldRadiobutton.isChecked(), false);
        Assert.assertEquals(page8.silverRadiobutton.isChecked(), false);
        Assert.assertEquals(page8.bronzeRadiobutton.isChecked(), false);
        Assert.assertEquals(page8.selenRadiobutton.isChecked(), true);
    }
}
