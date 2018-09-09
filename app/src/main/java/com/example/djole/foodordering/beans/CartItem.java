package com.example.djole.foodordering.beans;

/**
 * Created by Djole on 08-Sep-18.
 */

public class CartItem {
    private String itemName, price, quantity, additionals;

    public CartItem(String itemName, String price, String quantity, String additionals) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.additionals = additionals;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAdditionals() {
        return additionals;
    }

    public void setAdditionals(String additionals) {
        this.additionals = additionals;
    }
}
