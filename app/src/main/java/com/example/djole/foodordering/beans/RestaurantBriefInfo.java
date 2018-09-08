package com.example.djole.foodordering.beans;

/**
 * Created by Djole on 08-Sep-18.
 */

public class RestaurantBriefInfo {
    private String restName;
    private String restRating;
    private String restCuisine;
    private String workingHours;
    private int picture;

    public RestaurantBriefInfo(String restName, String restRating, String restCuisine, String workingHours, int picture) {
        this.restName = restName;
        this.restRating = restRating;
        this.restCuisine = restCuisine;
        this.workingHours = workingHours;
        this.picture = picture;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestRating() {
        return restRating;
    }

    public void setRestRating(String restRating) {
        this.restRating = restRating;
    }

    public String getRestCuisine() {
        return restCuisine;
    }

    public void setRestCuisine(String restCuisine) {
        this.restCuisine = restCuisine;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }
}
