package com.example.proiectcolectiv;

import java.util.Date;

public class Comment {
    private int commentID;
    private String userID;
    private int parentPostID;
    private int parentCommID;
    private String content;
    private int likes;
    private int dislikes;
    private Date date;

    public Comment(int commentID, String userID, int parentPostID, int parentCommID, String content, int likes, int dislikes, Date date) {
        this.commentID = commentID;
        this.userID = userID;
        this.parentPostID = parentPostID;
        this.parentCommID = parentCommID;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
        this.date = date;
    }
    public Comment(){}

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getParentPostID() {
        return parentPostID;
    }

    public void setParentPostID(int parentPostID) {
        this.parentPostID = parentPostID;
    }

    public int getParentCommID() {
        return parentCommID;
    }

    public void setParentCommID(int parentCommID) {
        this.parentCommID = parentCommID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
