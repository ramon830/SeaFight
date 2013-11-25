package com.seafight;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.11.13
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
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
