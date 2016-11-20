package com.controls.pages.surrounding.pageBlocks.metalsColorsPageBlocks.metalsColorsFormBlocks;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.IRadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class SummarySection extends Section{
    @FindBy(css = "#odds-selector p")
    public IRadioButtons odds;
    @FindBy(css = "#even-selector p")
    public IRadioButtons even;
    @FindBy(id = "calculate-button")
    public IButton calculate;
}
