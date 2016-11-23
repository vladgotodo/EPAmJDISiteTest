package com.controls.pages;

import com.controls.pages.surrounding.pageBlocks.MetalsColorsForm;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

public class MetalsColorsPage extends WebPage {
    @FindBy(css = ".form")
    public MetalsColorsForm metalsColorsForm = new MetalsColorsForm();

    @FindBy(css = ".summ-res")
    public IText summaryField;
    @FindBy(css = ".elem-res")
    public IText elementsField;
    @FindBy(css = ".col-res")
    public IText colorsField;
    @FindBy(css = ".met-res")
    public IText metalsField;
    @FindBy(css = ".sal-res")
    public IText saladField;
}
