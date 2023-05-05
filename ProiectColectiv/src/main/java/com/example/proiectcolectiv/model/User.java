package com.example.proiectcolectiv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.sql.Date;
@Entity
@Table(name = "user")
public  class User {
    @Id
    @Column(name = "userID")
    private String uid;
    @Column(name = "displayName")
    private String displayName;
    @Column(name = "photoURL")
    private String photoURL;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "joinDate")
    private Date joinDate;
    @Column(name = "position")
    private String position;

    public User(String uid, String displayName, String photoURL, String email, String password, Date joinDate, String position) {
        this.uid = uid;
        this.displayName = displayName;
        this.photoURL = photoURL;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        this.position = position;
    }
    public User(){}

    public String getUid() {
        return uid;
    }

    public void setUid(String userID) {
        this.uid = userID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String url) {
        this.photoURL = url;
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

