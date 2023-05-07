package com.example.proiectcolectiv.model;

public class Answer2 {
    private String code;
    private UserNewAdd user;
    private String answerTitle;
    private String answerDetails;

    public Answer2(String code, UserNewAdd user, String answerTitle, String answerDetails) {
        this.code = code;
        this.user = user;
        this.answerTitle = answerTitle;
        this.answerDetails = answerDetails;
    }
    public Answer2(){}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserNewAdd getUser() {
        return user;
    }

    public void setUser(UserNewAdd user) {
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

    @Override
    public String toString() {
        return "Answer2{" +
                "code='" + code + '\'' +
                ", user=" + user +
                ", answerTitle='" + answerTitle + '\'' +
                ", answerDetails='" + answerDetails + '\'' +
                '}';
    }
}
