package com.controls.pages;

import com.controls.pages.surrounding.generalBlocks.SearchField;
import com.epam.jdi.uitests.core.interfaces.complex.ISearch;
import com.epam.jdi.uitests.core.interfaces.complex.ISelector;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class TablePagesPage extends WebPage {
    @FindBy(id = "DataTables_Table_0")
    public ITable sortingTable;

    public Pagination tablePagination = new Pagination(By.id("DataTables_Table_0_wrapper"),
            By.linkText("Next"),
            By.linkText("Previous"));

    @FindBy(name = "DataTables_Table_0_length")
    public ISelector rowsNumberInPageDD;

    @FindBy(xpath = ".//input[@type='search']")
    public Search search;

    public TablePagesPage sortTableByHeader(String columnName) {
        sortingTable.header(columnName).click();
        return this;
    }
}
