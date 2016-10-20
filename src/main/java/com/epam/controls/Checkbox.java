package com.epam.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox extends Element{

    private By locator;
    private WebElement element;
    private WebDriver driver;

    public Checkbox(WebDriver driver, String text)
    {
        super(driver, text);
    }

    public void check()
    {
        if(!isChecked())
            getElement().click();
    }

    public void uncheck()
    {
        if(isChecked())
            getElement().click();
    }
}