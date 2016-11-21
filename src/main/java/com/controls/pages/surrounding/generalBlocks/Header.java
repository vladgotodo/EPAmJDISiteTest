package com.controls.pages.surrounding.generalBlocks;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.IImage;
import com.epam.jdi.uitests.core.interfaces.complex.IMenu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {
    @FindBy(id = "epam_logo")
    public IImage logo;

    @FindBy(css = ".m-l8>li>a")
    public IMenu headerMenuMain;

    @FindBy(css = ".m-l8>li>a>.dropdown-toggle>.dropdown-menu>li>a")
    public IMenu headerMenuService;

    @FindBy(css = ".icon-search")
    public IButton openSearchButton;

    @FindBy(css = ".search")
    public SearchField searchField;
}
