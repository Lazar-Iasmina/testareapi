package com.example.proiectcolectiv;

import java.util.Date;

public class Post {
    private int postID;
    private String userID;
    private String questionID;
    private String questionContent;
    private int  likes;
    private int disikes;
    private Date date;
    private String category;

    public Post(int postID, String userID, String questionID, String questionContent, int likes, int disikes, Date date, String category) {
        this.postID = postID;
        this.userID = userID;
        this.questionID = questionID;
        this.questionContent = questionContent;
        this.likes = likes;
        this.disikes = disikes;
        this.date = date;
        this.category = category;
    }
    private Post(){}

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

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDisikes() {
        return disikes;
    }

    public void setDisikes(int disikes) {
        this.disikes = disikes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
