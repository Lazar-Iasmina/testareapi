package com.example.proiectcolectiv.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "comment")

public class Comment {
    @Id
    @Column(name = "commentID")
    private Integer commentID;
    @Column(name = "userID")
    private String userID;
    @Column(name = "parentPostID")
    private Integer parentPostID;
    @Column(name = "parentCommID")
    private Integer parentCommID;
    @Column(name = "content")

    private String content;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "dislikes")
    private Integer dislikes;
    @Column(name = "date")
    private Date date;
    @Column(name="commentTitle")
    private String commentTitle;
    @Column(name="commentCode")
    private String commentCode;
    public Comment(Integer commentID, String userID, Integer parentPostID, Integer parentCommID, String content,Integer likes, Integer dislikes, Date date,String commentTitle,String commentCode) {
        this.commentID = commentID;
        this.userID = userID;
        this.parentPostID = parentPostID;
        this.parentCommID = parentCommID;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
        this.date = date;
        this.commentCode=commentCode;
        this.commentTitle=commentTitle;
    }

    public Comment() {
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getParentPostID() {
        return parentPostID;
    }

    public void setParentPostID(Integer parentPostID) {
        this.parentPostID = parentPostID;
    }

    public Integer getParentCommID() {
        return parentCommID;
    }

    public void setParentCommID(Integer parentCommID) {
        this.parentCommID = parentCommID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", userID='" + userID + '\'' +
                ", parentPostID=" + parentPostID +
                ", parentCommID=" + parentCommID +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", date=" + date +
                ", commentTitle='" + commentTitle + '\'' +
                ", commentCode='" + commentCode + '\'' +
                '}';
    }
}

