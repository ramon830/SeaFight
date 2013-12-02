package com.seafight;

public class User {
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password) {
    }

    public boolean enter(String login, String password) {
        return false;
    }

    public String getName() {
        return name;
    }
}
