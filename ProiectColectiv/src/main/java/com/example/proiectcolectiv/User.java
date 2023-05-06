package com.example.proiectcolectiv;

import java.util.Date;

public class User {
    private String userID;

    private String displayName;
    private String url;
    private String email;
    private String password;
    private Date joinDate;
    private String position;

    public User( String userID, String displayName, String url, String email, String password, Date joinDate, String position) {
        this.userID = userID;
        this.displayName = displayName;
        this.url = url;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        this.position = position;
    }
    public User(){}

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
