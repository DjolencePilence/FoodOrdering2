package com.example.djole.foodordering.beans;

/**
 * Created by Djole on 09-Sep-18.
 */

public class Impression {
    private String mark, postedBy, comment;

    public Impression(String mark, String postedBy, String comment) {
        this.mark = mark;
        this.postedBy = postedBy;
        this.comment = comment;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
