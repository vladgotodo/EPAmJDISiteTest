package com.controls.pages.surrounding.entities;

public class CFType {
    public static final CFType DEFAULT = new CFType();

    public String odds = "7";
    public String even = "8";
    public String nameField = "John";
    public String lastNameField = "Johnson";
    public String description = "blablabla";

    private CFType() {
    }


    public CFType(String odds, String even, String name, String lastName, String description) {
        this.odds = odds;
        this.even = even;
        this.nameField = name;
        this.lastNameField = lastName;
        this.description = description;
    }
}
