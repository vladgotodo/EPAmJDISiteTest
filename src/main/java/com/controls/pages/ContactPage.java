package com.controls.pages;

import com.controls.pages.surrounding.pageBlocks.ContactForm;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends WebPage {
    @FindBy(css = ".form")
    public ContactForm contactForm = new ContactForm();

    @FindBy(css = ".summ-res")
    public IText summaryField;
    @FindBy(css = ".name-res")
    public IText nameField;
    @FindBy(css = ".lname-res")
    public IText lastNameField;
    @FindBy(css = ".descr-res")
    public IText descriptionField;
}
