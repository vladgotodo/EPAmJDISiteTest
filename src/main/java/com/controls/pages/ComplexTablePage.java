package com.controls.pages;

import com.controls.pages.surrounding.enums.ColumnHeaders;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.DynamicTable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.controls.JDITestSite.complexTablePage;
public class ComplexTablePage extends WebPage {
    @FindBy(css = ".tbl-height>table")
    public DynamicTable dynamicTable;

    @FindBy(css = ".btn.dropdown-toggle.selectpicker.btn-default")
    public Button dropDownButton;

    public ColumnDropList<ColumnHeaders> tableColumnDD = new ColumnDropList<ColumnHeaders>(
            By.xpath("*//ul[contains(@class,'dropdown-menu inner selectpicker')]"),
            By.xpath("*//ul[contains(@class,'dropdown-menu inner selectpicker')]/li")) {
        @Override
        public void selectByName(String name) {
            complexTablePage.dropDownButton.click();
            complexTablePage.tableColumnDD.select(name);
            complexTablePage.dropDownButton.click();
        }
    };

    @FindBy(xpath = "*//button[text()='Reestablish']")
    public Button reestablishBtn;
    @FindBy(xpath = "*//button[text()='Apply']")
    public Button applyBtn;

    public abstract class ColumnDropList<ColHeaders extends Enum> extends DropList<ColHeaders> {
        public ColumnDropList(By xpath, By xpath1) {
            super(xpath, xpath1);
        }

        public abstract void selectByName(String name);
    }

    @Step
    public void addColumn(ColumnHeaders columnHeader) {
        this.tableColumnDD.selectByName(columnHeader.value);
        this.applyBtn.click();

        }

    @Step
    public void deleteColumn(ColumnHeaders columnHeader) {
        this.tableColumnDD.selectByName(columnHeader.value);
        this.applyBtn.click();

        }
}
