package ru.mai.softwaredevelopment.calendar.client.modules;

import java.util.Date;
import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private HashMap<Date, String> notes;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        notes = new HashMap<>();
    }

    public Boolean signUp() {
        return true;
    }

    public Boolean signIn() {
        return false;
    }

    public String getUsername() {
        return username;
    }

    public HashMap<Date, String> getNotes() {
        return notes;
    }
}
