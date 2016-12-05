package com.epam.uitest;

import com.epam.uitest.surrounding.DataProviders;
import com.epam.uitest.surrounding.InitTests;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.logPanel;
import static com.controls.JDITestSite.simpleTablePage;
import static com.controls.pages.surrounding.enums.Preconditions.LOGIN;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class SimpleTablePageTest extends InitTests {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "SimpleTablePageTableTest")
    public void simpleTableTest(int x, int y, String cellText) {
        isInState(LOGIN);
        simpleTablePage.isOpened();
        simpleTablePage.simplePageTable.isDisplayed();
        Assert.assertEquals(simpleTablePage.simplePageTable.cell(x, y).getText(), cellText,
                "Unexpected text in cell");
        simpleTablePage.simplePageTable.cell(x, y).click();
        Assert.contains(logPanel.getFirstText(), "value=" + simpleTablePage.simplePageTable.cell(x, y).getText() +
                "; cell has been selected", "No necessary field found in log panel");
    }
}
