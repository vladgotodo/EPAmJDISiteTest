package com.controls.pages.surrounding.fillingTypes;

public class ContactFormType {
    public static final ContactFormType DEFAULT = new ContactFormType();

    public String odds = "7";
    public String even = "8";
    public String nameField = "John";
    public String lastNameField = "Johnson";
    public String description = "blablabla";

    private ContactFormType() {
    }


    public ContactFormType(String odds, String even, String name, String lastName, String description) {
        this.odds = odds;
        this.even = even;
        this.nameField = name;
        this.lastNameField = lastName;
        this.description = description;
    }
}
