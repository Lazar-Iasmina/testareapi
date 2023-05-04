package com.example.proiectcolectiv.model;

public class User1 {
    private String photoURL;
    private String displayName;

    public User1(String photoURL, String displayName) {
        this.photoURL = photoURL;
        this.displayName = displayName;
    }
    public User1(){}

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
