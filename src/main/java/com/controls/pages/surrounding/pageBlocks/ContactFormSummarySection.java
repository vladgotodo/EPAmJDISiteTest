package com.controls.pages.surrounding.pageBlocks;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.IRadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

class ContactFormSummarySection extends Section{
    @FindBy(css = ".horizontal-group p")
    public IRadioButtons odds;
    @FindBy(css = ".horizontal-group p")
    public IRadioButtons even;
    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/form/div[3]/div[1]/section/div[2]/div/div/button")
    public IButton calculate;
}
