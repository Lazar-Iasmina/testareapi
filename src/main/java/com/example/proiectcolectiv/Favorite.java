package com.example.proiectcolectiv;

public class Favorite {
    private String idFav;
    private int postID;
    private String userID;

    public Favorite(String idFav, int postID, String userID) {
        this.idFav = idFav;
        this.postID = postID;
        this.userID = userID;
    }
    public Favorite(){}

    public String getIdFav() {
        return idFav;
    }

    public void setIdFav(String idFav) {
        this.idFav = idFav;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
