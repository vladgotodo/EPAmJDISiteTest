package com.controls.pages.surrounding.pageBlocks;

import com.controls.pages.surrounding.fillingTypes.CFType;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextArea;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class ContactForm extends Form<CFType> {
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
    public void submit(CFType сFType) {
        contactFormSummarySection.odds.select(сFType.odds);
        contactFormSummarySection.even.select(сFType.even);
        descriptionField.sendKeys(сFType.description);
        super.submit(сFType);
    }
}
