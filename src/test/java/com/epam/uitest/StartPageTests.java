package com.epam.uitest;

import com.epam.uitest.surrounding.InitTests;
import com.epam.uitest.surrounding.dataproviders.DataProviders;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.*;

public class StartPageTests extends InitTests {
    @Test(groups = "SearchField", dataProviderClass = DataProviders.class, dataProvider = "SearchFieldTest")
    public void simpliestTest(String searchRequest) {
        header.searchField.findAction(searchRequest);
        supportPage.checkOpened();
        contactPage.checkOpened();
    }
}