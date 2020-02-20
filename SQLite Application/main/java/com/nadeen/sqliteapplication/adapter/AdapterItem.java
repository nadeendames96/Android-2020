package com.nadeen.sqliteapplication.adapter;

public class AdapterItem {
    public int ID;
    public String username;
    private String password;

    public AdapterItem(int ID, String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

