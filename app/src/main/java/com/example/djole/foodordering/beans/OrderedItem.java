package com.example.djole.foodordering.beans;

/**
 * Created by Djole on 09-Sep-18.
 */

public class OrderedItem {
    private String title, price, time, restaurant, quantity;

    public OrderedItem(String title, String price, String time, String restaurant, String quantity) {
        this.title = title;
        this.price = price;
        this.time = time;
        this.restaurant = restaurant;
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}
