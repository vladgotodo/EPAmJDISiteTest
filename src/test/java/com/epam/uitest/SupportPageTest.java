package com.epam.uitest;

import com.epam.uitest.surrounding.DataProviders;
import com.epam.uitest.surrounding.InitTests;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.supportPage;
import static com.controls.pages.surrounding.enums.Preconditions.LOGIN;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class SupportPageTest extends InitTests {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "SimpleTablePageTableTest")
    public void simpleTableTest(int x, int y, String cellText) {
        isInState(LOGIN);
        supportPage.open();
        supportPage.supportPageTable.isDisplayed();
        Assert.assertEquals(supportPage.supportPageTable.cell(x, y).getText(), cellText,
                "Unexpected text in cell");
    }
}
