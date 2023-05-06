package com.example.proiectcolectiv.model;

public class Answer {
    private String code;
    private User1 user;
    private String answerTitle;
    private String answerDetails;

    public Answer() {
    }

    public Answer(String code, User1 user, String answerTitle, String answerDetails) {
        this.code = code;
        this.user = user;
        this.answerTitle = answerTitle;
        this.answerDetails = answerDetails;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User1 getUser() {
        return user;
    }

    public void setUser(User1 user) {
        this.user = user;
    }

    public String getAnswerTitle() {
        return answerTitle;
    }

    public void setAnswerTitle(String answerTitle) {
        this.answerTitle = answerTitle;
    }

    public String getAnswerDetails() {
        return answerDetails;
    }

    public void setAnswerDetails(String answerDetails) {
        this.answerDetails = answerDetails;
    }
}
