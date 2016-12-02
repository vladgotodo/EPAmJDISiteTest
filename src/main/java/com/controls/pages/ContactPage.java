package com.controls.pages;

import com.controls.pages.surrounding.entities.CFType;
import com.controls.pages.surrounding.pageBlocks.ContactForm;
import com.controls.pages.surrounding.pageBlocks.ContactFormSummarySection;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends WebPage {
    @FindBy(css = ".panel-gray")
    private ContactFormSummarySection contactFormSummarySection;
    @FindBy(css = ".form")
    public ContactForm contactForm;

    public void submit(CFType сFType) {
        contactFormSummarySection.odds.select(сFType.odds);
        contactFormSummarySection.even.select(сFType.even);
        contactForm.submit(сFType);
    }

    @FindBy(css = ".summ-res")
    public IText summaryField;
    @FindBy(css = ".name-res")
    public IText nameField;
    @FindBy(css = ".lname-res")
    public IText lastNameField;
    @FindBy(css = ".descr-res")
    public IText descriptionField;
}
