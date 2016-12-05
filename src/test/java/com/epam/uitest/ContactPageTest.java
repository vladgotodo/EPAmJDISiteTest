package com.epam.uitest;

import com.controls.pages.surrounding.entities.CFType;
import com.epam.uitest.surrounding.DataProviders;
import com.epam.uitest.surrounding.InitTests;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.contactPage;
import static com.controls.pages.surrounding.enums.Preconditions.CPPAGE_OPENED;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class ContactPageTest extends InitTests {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "ContactFormTest")
        public void contactFormTest(CFType cFType) {
            isInState(CPPAGE_OPENED);
            contactPage.submit(cFType);
            Assert.areEquals(contactPage.summaryField.getText().substring(9,
                    contactPage.summaryField.getText().length()),
                    String.valueOf(Integer.parseInt(cFType.odds) + Integer.parseInt(cFType.even)),
                    "Unexpected result in result panel(\"summary field\")");
            Assert.contains(contactPage.nameField.getText().substring(6,
                    contactPage.nameField.getText().length()), cFType.nameField,
                    "Unexpected result in result panel(\"name field\")");
            Assert.contains(contactPage.lastNameField.getText().substring(11,
                    contactPage.lastNameField.getText().length()), cFType.lastNameField,
                    "Unexpected result in result panel(\"last name field\")");
            Assert.contains(contactPage.descriptionField.getText().substring(13,
                    contactPage.descriptionField.getText().length()), cFType.description,
                    "Unexpected result in result panel(\"description field\")");
    }
}
