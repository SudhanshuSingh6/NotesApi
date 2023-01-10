package com.sudhanshu.notesapi.request;

public class AddUserReq {
    private String username;
    private String password;

    public AddUserReq() {
    }

    public AddUserReq(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}