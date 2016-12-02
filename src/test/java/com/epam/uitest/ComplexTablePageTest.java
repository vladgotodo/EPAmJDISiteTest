package com.epam.uitest;

import com.controls.pages.surrounding.enums.ColumnHeaders;
import com.epam.uitest.surrounding.InitTests;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.complexTablePage;
import static com.controls.pages.surrounding.enums.Preconditions.CTPAGE_OPENED;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class ComplexTablePageTest extends InitTests {
    @BeforeMethod
    public void setUp() {
        isInState(CTPAGE_OPENED);
    }

    @Test
    public void complexTablePageTest() {
        //Chrome bug
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 3, "Unexpected colums count");
        complexTablePage.deleteColumn(ColumnHeaders.col1);
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 2, "Unexpected colums count");
        complexTablePage.deleteColumn(ColumnHeaders.col2);
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 1, "Unexpected colums count");
        complexTablePage.addColumn(ColumnHeaders.col1);
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 2, "Unexpected colums count");
        complexTablePage.addColumn(ColumnHeaders.col2);
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 3, "Unexpected colums count");
        complexTablePage.addColumn(ColumnHeaders.col3);
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 4, "Unexpected colums count");
        complexTablePage.deleteColumn(ColumnHeaders.col1);
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 3, "Unexpected colums count");
        complexTablePage.deleteColumn(ColumnHeaders.col2);
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 2, "Unexpected colums count");
        complexTablePage.deleteColumn(ColumnHeaders.col3);
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 1, "Unexpected colums count");
        complexTablePage.reestablishBtn.click();
        Assert.assertEquals(complexTablePage.dynamicTable.columns().count(), 4, "Unexpected colums count");
    }
}
