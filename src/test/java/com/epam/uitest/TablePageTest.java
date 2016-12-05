package com.epam.uitest;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.uitest.surrounding.DataProviders;
import com.epam.uitest.surrounding.InitTests;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.tablePagesPage;
import static com.controls.pages.surrounding.enums.Preconditions.TPPAGE_OPENED;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class TablePageTest extends InitTests {

    @BeforeTest
    public static void setUpBeforeTests() {
        isInState(TPPAGE_OPENED);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "RowsCountTablePageTest")
    public void entriesDropdownTest(int rowsCount) {
        tablePagesPage.sortingTable.isDisplayed();
        tablePagesPage.rowsNumberInPageDD.select(String.valueOf(rowsCount));
        rowsCount = (rowsCount > 10) ? 11 : rowsCount;
        Assert.assertEquals(tablePagesPage.sortingTable.rows().count(), rowsCount, "Unexpected rows count");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "SearchTablePageTest")
    public void searchTableTest(boolean valid, int rowsCount, int column, String searchRequest) {
        tablePagesPage.search.isDisplayed();
        tablePagesPage.sortingTable.isDisplayed();
        tablePagesPage.rowsNumberInPageDD.select("15");
        tablePagesPage.search.input(searchRequest);
        int actualRowsCount = tablePagesPage.sortingTable.rows().count();
        Table tableCopy = tablePagesPage.sortingTable.clone();
        tablePagesPage.search.clear();
        Assert.assertEquals(actualRowsCount, rowsCount, "Unexpected rows count");
        if (valid) {
            for(int i = 1; i <= rowsCount; i++)
                Assert.ignoreCase().contains(tableCopy.cell(column, i).getText(), searchRequest,
                        "Unexpected table search results");
        }
        else {
            Assert.areEquals(tableCopy.cell(1, 1).getText(), "No matching records found",
                    "Unexpected table search results");
        }
    }

    @Test
    public void paginationTableTest() {
        tablePagesPage.sortingTable.isDisplayed();
        Assert.assertEquals(tablePagesPage.sortingTable.rows().count(), 5, "Unexpected rows count");
        tablePagesPage.tablePagination.next();
        Assert.assertEquals(tablePagesPage.sortingTable.rows().count(), 5, "Unexpected rows count");
        tablePagesPage.tablePagination.next();
        Assert.assertEquals(tablePagesPage.sortingTable.rows().count(), 1, "Unexpected rows count");
        tablePagesPage.rowsNumberInPageDD.select("10");
        Assert.assertEquals(tablePagesPage.sortingTable.rows().count(), 10, "Unexpected rows count");
        tablePagesPage.tablePagination.next();
        Assert.assertEquals(tablePagesPage.sortingTable.rows().count(), 1, "Unexpected rows count");
    }
}