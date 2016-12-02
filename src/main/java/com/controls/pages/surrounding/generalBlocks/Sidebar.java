package com.controls.pages.surrounding.generalBlocks;

import com.epam.jdi.uitests.core.interfaces.complex.IMenu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Sidebar extends Section {
    @FindBy(css = ".sidebar-menu")
    public IMenu sidebarMenu;
}
