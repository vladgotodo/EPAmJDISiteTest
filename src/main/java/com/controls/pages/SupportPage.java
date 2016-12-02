package com.controls.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

public class SupportPage extends WebPage {
    @FindBy(css = ".uui-table")
    public ITable supportPageTable;
}
