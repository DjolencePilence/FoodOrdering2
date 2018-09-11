package com.example.djole.foodordering.beans;

/**
 * Created by Djole on 11-Sep-18.
 */

public class PreviousDeliveryItem {
    private String item, price, deliveryTime, purchaser,address;
    private int picture;

    public PreviousDeliveryItem(String item, String price, String deliveryTime, String purchaser, String address, int picture) {
        this.item = item;
        this.price = price;
        this.deliveryTime = deliveryTime;
        this.purchaser = purchaser;
        this.address = address;
        this.picture = picture;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeadline() {
        return deliveryTime;
    }

    public void setDeadline(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
