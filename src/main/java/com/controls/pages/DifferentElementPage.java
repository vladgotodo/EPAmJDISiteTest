package com.controls.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.core.interfaces.complex.IRadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.support.FindBy;

public class DifferentElementPage extends WebPage {
    @FindBy(css = ".checkbox-row label")
    public ICheckList elementsChecklist;
    @FindBy(css = ".checkbox-row label")
    public IRadioButtons metalsChecklist;
    @JDropdown(
            root = @FindBy(css = ".colors"),
            value = @FindBy(css = ".colors>.uui-form-element"),
            elementByName = @FindBy(tagName = "option")
    )
    public IDropDown colorDropdown;
    @FindBy(xpath = "//button[@name='Default Button']")
    public IButton button;
    @FindBy(xpath = "//input[@value='Button']")
    public IButton defaultButton;
}
