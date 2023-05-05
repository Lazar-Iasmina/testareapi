package com.example.proiectcolectiv.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Label")
public class Label {

    @Column(name = "labelID")
    private  String labelID;
    @Id
    @Column(name="postID")
    private Integer postID;

    public Label(String labelID, Integer postID) {
        this.labelID = labelID;
        this.postID = postID;
    }

    public String getLabelID() {
        return labelID;
    }

    public void setLabelID(String labelID) {
        this.labelID = labelID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }
    public Label(){}
}
