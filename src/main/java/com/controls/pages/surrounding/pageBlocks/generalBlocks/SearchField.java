package com.controls.pages.surrounding.pageBlocks.generalBlocks;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import org.openqa.selenium.support.FindBy;

public class SearchField extends Search {
    @FindBy(css = ".search-field input")
    public ITextField searchInput;

    @FindBy(css = ".search .icon-search")
    public IButton searchButton;

    @Override
    public void findAction(String text) {
        searchButton.click();
        searchInput.sendKeys(text);
        searchButton.click();
    }
}
