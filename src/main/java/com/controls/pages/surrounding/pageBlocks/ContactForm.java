package com.controls.pages.surrounding.pageBlocks;

import com.controls.pages.surrounding.fillingTypes.ContactFormType;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextArea;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class ContactForm extends Form<ContactFormType> {
    @FindBy(css = ".panel-gray")
    private ContactFormSummarySection contactFormSummarySection = new ContactFormSummarySection();
    @FindBy(id = "Name")
    private ITextField nameField;
    @FindBy(id = "LastName")
    private ITextField lastNameField;
    @FindBy(id = "Description")
    private ITextArea descriptionField;
    @FindBy(xpath = "//*[text()='Submit']")
    public IButton submit;

    @Override
    public void submit(ContactFormType contactFormType) {
        contactFormSummarySection.odds.select(contactFormType.odds);
        contactFormSummarySection.even.select(contactFormType.even);
        descriptionField.sendKeys(contactFormType.description);
        super.submit(contactFormType);
    }
}
