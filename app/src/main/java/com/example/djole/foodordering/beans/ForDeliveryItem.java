package com.example.djole.foodordering.beans;

/**
 * Created by Djole on 10-Sep-18.
 */

public class ForDeliveryItem {
    private String itemName, price, orderer,deliverBefore, quantity;
    private int picture;

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public ForDeliveryItem(String itemName, String price, String orderer, String deliverBefore, int picture, String quantity) {
        this.itemName = itemName;
        this.price = price;
        this.orderer = orderer;
        this.deliverBefore = deliverBefore;
        this.picture = picture;
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderer() {
        return orderer;
    }

    public void setOrderer(String orderer) {
        this.orderer = orderer;
    }

    public String getDeliverBefore() {
        return deliverBefore;
    }

    public void setDeliverBefore(String deliverBefore) {
        this.deliverBefore = deliverBefore;
    }
}
