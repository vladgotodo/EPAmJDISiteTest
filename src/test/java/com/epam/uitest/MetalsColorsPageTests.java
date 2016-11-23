package com.epam.uitest;

import com.controls.pages.surrounding.fillingTypes.Plate;
import com.epam.uitest.surrounding.InitTests;
import com.epam.uitest.surrounding.dataproviders.DataProviders;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.metalsColorsPage;

public class MetalsColorsPageTests extends InitTests {

    @BeforeMethod
    public void before() {
        metalsColorsPage.open();
        metalsColorsPage.checkOpened();
    }

    @Test(groups = "metalsColorsFormTest", dataProviderClass = DataProviders.class, dataProvider = "MetalsColorsTest")
    public void metalsColorsFormTest(Plate plate) {
        metalsColorsPage.metalsColorsForm.submit(plate);
        Assert.contains(metalsColorsPage.summaryField.getText(), String.valueOf(Integer.parseInt(plate.odds)
            + Integer.parseInt(plate.even)));
        for(String element : plate.elementsCheckList)
            Assert.contains(metalsColorsPage.elementsField.getText(), element);
        Assert.contains(metalsColorsPage.colorsField.getText(), plate.color);
        Assert.contains(metalsColorsPage.metalsField.getText(), plate.metalsComboBox);
        for(String element : plate.saladDroplist)
            Assert.contains(metalsColorsPage.saladField.getText(), element);
    }
}
