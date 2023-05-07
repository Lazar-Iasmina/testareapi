package com.example.proiectcolectiv.model;

import java.sql.Date;
import java.util.List;

public class QuestionPremium {
    private Integer questionID;
    private UserNewAdd user;
    private List<String> questionLabels;
    private String questionTitle;
    private String questionContent;
    private Integer likes;
    private Integer dislikes;
    private Date date;
    private String category;
    private String code;
    private List<Answer> answers;

    public QuestionPremium(Integer questionID, UserNewAdd user, List<String> questionLabels, String questionTitle, String questionContent, Integer likes, Integer dislikes, Date date, String category, String code, List<Answer> answers) {
        this.questionID = questionID;
        this.user = user;
        this.questionLabels = questionLabels;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.likes = likes;
        this.dislikes = dislikes;
        this.date = date;
        this.category = category;
        this.code = code;
        this.answers = answers;
    }
    public QuestionPremium(){}

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }

    public UserNewAdd getUser() {
        return user;
    }

    public void setUser(UserNewAdd user) {
        this.user = user;
    }

    public List<String> getQuestionLabels() {
        return questionLabels;
    }

    public void setQuestionLabels(List<String> questionLabels) {
        this.questionLabels = questionLabels;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "QuestionPremium{" +
                "questionID=" + questionID +
                ", user=" + user +
                ", questionLabels=" + questionLabels +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", code='" + code + '\'' +
                ", answers=" + answers +
                '}';
    }
}
