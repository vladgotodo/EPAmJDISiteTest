package com.controls.pages.surrounding.other;

public class User {
    public static final User DEFAULT = new User();

    private String login = "epam";
    private String password = "1234";
    public String name = "Piter Chailovskii";

    private User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

