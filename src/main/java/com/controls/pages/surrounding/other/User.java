package com.controls.pages.surrounding.other;

public class User {
    public static final User DEFAULT = new User();

    public String login = "epam";
    public String password = "1234";
    public String name = "Piter Chailovskii";

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

