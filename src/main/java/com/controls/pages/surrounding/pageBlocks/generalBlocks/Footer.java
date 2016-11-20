package com.controls.pages.surrounding.pageBlocks.generalBlocks;

import com.epam.jdi.uitests.core.interfaces.complex.IMenu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Footer extends Section {
    @FindBy(css = ".footer-menu>li>a")
    public IMenu footerMenu;
}
