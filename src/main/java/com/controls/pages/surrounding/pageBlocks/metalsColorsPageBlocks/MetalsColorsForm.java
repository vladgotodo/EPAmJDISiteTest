package com.controls.pages.surrounding.pageBlocks.metalsColorsPageBlocks;

import com.controls.pages.surrounding.pageBlocks.metalsColorsPageBlocks.metalsColorsFormBlocks.*;
import com.controls.pages.surrounding.pageBlocks.metalsColorsPageBlocks.metalsColorsFormBlocks.other.Plate;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IComboBox;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.core.interfaces.complex.IDropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page2.htm", title = "Metal and Colors")
public class MetalsColorsForm extends Form<Plate> {
    @FindBy(id = "summary-block")
    private SummarySection summarySection = new SummarySection();
    @FindBy(css = "#elements-checklist label")
    private ICheckList elementsCheckList;
    private IDropDown colorsDropdown = new Dropdown(By.cssSelector(".colors .filter-option"),
            By.cssSelector(".colors li span"));
    private IComboBox metalsComboBox = new ComboBox(By.cssSelector(".metals .caret"),
            By.cssSelector(".metals li span"), By.cssSelector(".metals input"));
    private IDropList saladDroplist = new DropList(By.cssSelector(".salad .caret"),
            By.cssSelector(".salad li label"));
    @FindBy(id = "submit-button")
    private IButton submit;

    @Override
    public void submit(Plate plate) {
        summarySection.odds.select(plate.odds);
        summarySection.even.select(plate.even);
        elementsCheckList.select(plate.elementsCheckList);
        colorsDropdown.click();
        colorsDropdown.select(plate.color);
        saladDroplist.select("Salad");
        saladDroplist.select(plate.saladDroplist);
        super.submit(plate);
    }
}
