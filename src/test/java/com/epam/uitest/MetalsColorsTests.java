package com.epam.uitest;

import com.controls.pages.surrounding.pageBlocks.metalsColorsPageBlocks.metalsColorsFormBlocks.other.Plate;
import com.epam.uitest.surrounding.InitTests;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.metalsColorsPage;

public class MetalsColorsTests extends InitTests {
    @BeforeClass
    public void before() {
        metalsColorsPage.open();
        metalsColorsPage.checkOpened();
    }

    @Test
    public void simpliestTest() {
        metalsColorsPage.checkOpened();
        Plate plate = Plate.DEFAULT;
        metalsColorsPage.metalsColorsForm.submit(Plate.DEFAULT);
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
