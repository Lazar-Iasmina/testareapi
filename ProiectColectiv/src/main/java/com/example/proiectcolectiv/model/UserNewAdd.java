package com.example.proiectcolectiv.model;

public class UserNewAdd {
    private String uid;
    private String photoURL;
    private String displayName;

    public UserNewAdd(String uid, String photoURL, String displayName) {
        this.uid = uid;
        this.photoURL = photoURL;
        this.displayName = displayName;
    }
    public UserNewAdd(){}

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

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
