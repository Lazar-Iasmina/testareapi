package com.example.proiectcolectiv.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "favorite")

public class Favorite {
    @Id
    @Column(name = "idFav")
    private Integer idFav;
    @Column(name = "postID")
    private int postID;
    @Column(name = "userID")
    private Integer userID;

    public Favorite(Integer idFav, int postID, Integer userID) {
        this.idFav = idFav;
        this.postID = postID;
        this.userID = userID;
    }
    public Favorite(){}

    public Integer getIdFav() {
        return idFav;
    }

    public void setIdFav(Integer idFav) {
        this.idFav = idFav;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
