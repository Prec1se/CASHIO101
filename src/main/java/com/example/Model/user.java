package com.example.Model;

import com.example.DbHandler.userHandler;

public abstract class user {
    private String userName;
    private int password, userID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getPassword() {
//        return userHandler.getPassword();
//    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getUserID() { return userID; }

    public void setUserID(int userID) { this.userID = userID; }

    public user() {
        userName = "";
        password = 12345678;
        userID = 0;
    }
    public user(String userName, int password, int userID) {
        this.userName = userName;
        this.password = password;
        this.userID = userID;
    }
}
