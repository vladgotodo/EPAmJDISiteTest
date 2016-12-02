package com.controls.pages;

import com.controls.pages.surrounding.JSLoader;
import com.controls.pages.surrounding.pageBlocks.ContactForm;
import com.controls.pages.surrounding.pageBlocks.DatesPageClock;
import com.epam.jdi.uitests.core.interfaces.common.IDatePicker;
import com.epam.jdi.uitests.core.interfaces.common.ILabel;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.robot.RFileInput;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.settings.WebSettings;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;

public class DatesPage extends WebPage {
    public DatesPageClock datesPageClock;


    @FindBy(css = ".form")
    public ContactForm contactForm;

    @FindBy(css = "#datepicker input")
    public IDatePicker datepicker;
    @FindBy(css = ".name-res")
    public IText nameField;
    @FindBy(css = ".lname-res")
    public IText lastNameField;
    @FindBy(css = ".descr-res")
    public IText descriptionField;
    @FindBy(css = ".time-res")
    public IText timeField;
    @FindBy(css = ".date-res")
    public IText calendarField;
    @FindBy(css = ".range-res")
    public IText range1Field;
    @FindBy(css = ".slider-res")
    public IText range2Field;

    @FindBy(css = "div[data-provides=fileinput]")
    public RFileInput imageInput;
    @FindBy(css = ".filename span")
    public ILabel uploadedFileName;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/form/div[4]/div[1]/div/input[1]")
    public ITextField range1From;
    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/form/div[4]/div[1]/div/input[2]")
    public ITextField range1To;

    @FindBy(xpath = ".//a[1][@class='ui-slider-handle ui-state-default ui-corner-all']")
    public Link leftRoller;
    @FindBy(xpath = ".//a[2][@class='ui-slider-handle ui-state-default ui-corner-all']")
    public Link rightRoller;

    private JavascriptExecutor javaScriptExecutor;

    private JavascriptExecutor getJSExecutor() {
        if (javaScriptExecutor == null) {
            javaScriptExecutor = (JavascriptExecutor) WebSettings.getDriverFactory().getDriver();
        }
        return javaScriptExecutor;
    }

    public void setLeftRollerPosition(int position) throws WebDriverException {
        JSLoader jsLoader = new JSLoader();
        String[][] keyWords = {{"LEFT_POS", String.valueOf(position)}};
        getJSExecutor().executeScript(jsLoader.getJSFromFile("JavaScript/rollerLeft.js", keyWords));
        leftRoller.click();
    }

    public void setRightRollerPosition(int position) {
        JSLoader jsLoader = new JSLoader();
        String[][] keyWords = {{"RIGHT_POS", String.valueOf(position)}};
        getJSExecutor().executeScript(jsLoader.getJSFromFile("JavaScript/rollerRight.js", keyWords));

        rightRoller.click();
    }
}
