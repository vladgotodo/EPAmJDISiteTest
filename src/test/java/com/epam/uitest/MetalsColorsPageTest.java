package com.epam.uitest;

import com.controls.pages.surrounding.entities.Plate;
import com.epam.uitest.surrounding.InitTests;
import com.epam.uitest.surrounding.DataProviders;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.*;

import static com.controls.JDITestSite.contactPage;
import static com.controls.pages.surrounding.enums.Preconditions.MCPAGE_OPENED;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static com.controls.JDITestSite.metalsColorsPage;

public class MetalsColorsPageTest extends InitTests {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "MetalsColorsTest")
    public void metalsColorsFormTest(boolean valid, Plate plate) {
        isInState(MCPAGE_OPENED);
        metalsColorsPage.metalsColorsForm.submit(plate);
        metalsColorsPage.metalsColorsForm.uncheckElements(plate);
        Assert.areEquals(contactPage.summaryField.getText().substring(9, contactPage.summaryField.getText().length()),
                String.valueOf(Integer.parseInt(plate.odds) + Integer.parseInt(plate.even)),
                "Unexpected result in result panel(\"summary field\")");
        Assert.arrayEquals(metalsColorsPage.elementsField.getText().substring(10, metalsColorsPage.elementsField.
                        getText().length()).replaceAll(", ", " ").split(" "), plate.elementsCheckList,
                "Unexpected result in result panel(\"elements field\")");
        if (valid) {
            Assert.areEquals(metalsColorsPage.colorsField.getText().substring(7, metalsColorsPage.colorsField.getText().
                    length()), plate.color, "Unexpected result in result panel(\"colors field\")");
            Assert.areEquals(metalsColorsPage.metalsField.getText().substring(7, metalsColorsPage.metalsField.getText().
                    length()), plate.metalsComboBox, "Unexpected result in result panel(\"metals field\")");
        }
        else {
            Assert.areDifferent(metalsColorsPage.colorsField.getText().substring(7, metalsColorsPage.colorsField.
                            getText().length()), plate.color, "Unexpected result in result panel(\"colors field\")");
            Assert.areDifferent(metalsColorsPage.metalsField.getText().substring(7, metalsColorsPage.metalsField.
                            getText().length()), plate.metalsComboBox, "Unexpected result in result panel(\"metals field\")");
        }
        Assert.arrayEquals(metalsColorsPage.saladField.getText().substring(12,
                metalsColorsPage.saladField.getText().length()).replaceAll(", ", " ").split(" "),
                plate.saladDroplist, "Unexpected result in result panel(\"salad field\")");
        /* UNUSED BECAUSE IT IS A BUG
        metalsColorsPage.metalsColorsForm.uncheckElements(plate);*/
    }
}
