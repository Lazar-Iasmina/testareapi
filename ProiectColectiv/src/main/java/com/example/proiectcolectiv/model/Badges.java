package com.example.proiectcolectiv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "badges")
public class Badges {
    @Id
    @Column(name = "idBadges")
    private String idBadges;
    @Column(name = "userID")
    private String userID;

    @Column(name = "badgeType")
    private String badgeType;

    public Badges(String idBadges, String userID, String badgeType) {
        this.idBadges = idBadges;
        this.userID = userID;
        this.badgeType = badgeType;
    }

    public Badges() {
    }

    public String getIdBadges() {
        return idBadges;
    }

    public void setIdBadges(String idBadges) {
        this.idBadges = idBadges;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

}