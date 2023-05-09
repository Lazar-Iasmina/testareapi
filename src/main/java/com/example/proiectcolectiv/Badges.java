package com.example.proiectcolectiv;

public class Badges {
    private String idBadges;
    private String userID;
    private String badgeType;

    public Badges(String idBadges, String userID, String badgeType) {
        this.idBadges = idBadges;
        this.userID = userID;
        this.badgeType = badgeType;
    }
    public Badges(){}
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
