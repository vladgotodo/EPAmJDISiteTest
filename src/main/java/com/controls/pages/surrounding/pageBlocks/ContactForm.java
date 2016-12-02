package com.controls.pages.surrounding.pageBlocks;

import com.controls.pages.surrounding.entities.CFType;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextArea;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class ContactForm extends Form<CFType> {
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
        nameField.clear();
        lastNameField.clear();
        descriptionField.clear();
        descriptionField.sendKeys(сFType.description);
        super.submit(сFType);
    }
}
