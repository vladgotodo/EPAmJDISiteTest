package com.epam.controls.pages;

import com.epam.controls.pages.surrounding.BasePage;
import com.epam.controls.pages.surrounding.pageBlocks.Checkbox;
import com.epam.controls.pages.surrounding.pageBlocks.Radiobutton;
import org.openqa.selenium.WebDriver;

public class Page8 extends BasePage {
    private static final String URL_PAGE = "https://jdi-framework.github.io/tests/page8.htm";

    public Checkbox waterCheckbox;
    public Checkbox earthCheckbox;
    public Checkbox windCheckbox;
    public Checkbox fireCheckbox;
    public Radiobutton goldRadiobutton;
    public Radiobutton silverRadiobutton;
    public Radiobutton bronzeRadiobutton;
    public Radiobutton selenRadiobutton;

    public Page8(WebDriver driver) {
        super(driver,URL_PAGE);

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
