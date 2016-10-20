package com.epam.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page8 {
    private WebDriver driver;
    private static String URL = "https://jdi-framework.github.io/tests/page8.htm";

    public Checkbox waterCheckbox;
    public Checkbox earthCheckbox;
    public Checkbox windCheckbox;
    public Checkbox fireCheckbox;
    public Radiobutton goldRadiobutton;
    public Radiobutton silverRadiobutton;
    public Radiobutton bronzeRadiobutton;
    public Radiobutton selenRadiobutton;

    public Page8(WebDriver driver) {
        if (!URL.equals(driver.getCurrentUrl())) {
            throw new IllegalStateException("This is not a required page");
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;

        waterCheckbox = new Checkbox(driver, "Water");
        earthCheckbox = new Checkbox(driver, "Earth");
        windCheckbox = new Checkbox(driver, "Wind");
        fireCheckbox = new Checkbox(driver, "Fire");
        goldRadiobutton = new Radiobutton(driver, "Gold");
        silverRadiobutton = new Radiobutton(driver, "Silver");
        bronzeRadiobutton = new Radiobutton(driver, "Bronze");
        selenRadiobutton = new Radiobutton(driver, "Selen");
    }
}
