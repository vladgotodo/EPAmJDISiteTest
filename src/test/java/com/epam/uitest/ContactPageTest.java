package com.epam.uitest;

import com.controls.pages.surrounding.fillingTypes.CFType;
import com.epam.uitest.surrounding.InitTests;
import com.epam.uitest.surrounding.dataproviders.DataProviders;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.Test;

import static com.controls.JDITestSite.contactPage;
import static com.controls.pages.surrounding.Preconditions.CPPAGE_OPENED;
import static com.controls.pages.surrounding.Preconditions.SPPAGE_OPENED;
import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;

public class ContactPageTest extends InitTests {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "ContactFormTest")
    public void contactFormTest(CFType сFType) {
        isInState(CPPAGE_OPENED);
        contactPage.contactForm.submit(сFType);
        Assert.contains(contactPage.summaryField.getText(), String.valueOf(Integer.parseInt(сFType.odds)
                + Integer.parseInt(сFType.even)));
        Assert.contains(contactPage.nameField.getText(), сFType.nameField);
        Assert.contains(contactPage.lastNameField.getText(), сFType.lastNameField);
        Assert.contains(contactPage.descriptionField.getText(), сFType.description);
    }
}
