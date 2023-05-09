package com.example.proiectcolectiv.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "post")

public  class Post {
    @Id
    @Column(name = "postID")
    private Integer postID;
    @Column(name = "userID")
    private String userID;
    @Column(name = "questionTitle")
    private String questionTitle;
    @Column(name = "questionContent")
    private String questionContent;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "dislikes")

    private Integer disikes;
    @Column(name = "date")
    private Date date;
    @Column(name = "category")
    private String category;
    @Column(name="questionCode")
    private String questionCode;



    public Post(Integer postID, String userID, String questionTitle, String questionContent, Integer likes, Integer disikes, Date date, String category,String questionCode) {
        this.postID = postID;
        this.userID = userID;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.likes = likes;
        this.disikes = disikes;
        this.date = date;
        this.category = category;
        this.questionCode=questionCode;
    }
    public Post(){}

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionID) {
        this.questionTitle = questionID;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDisikes() {
        return disikes;
    }

    public void setDisikes(Integer disikes) {
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

