package com.example.myapplication.models;

import java.io.Serializable;


public class CartItem implements Serializable {

    String CartItemID;
    Items item;
    int quantity;


    public CartItem() {
    }

    public CartItem(String CartItemID, Items item, int quantity) {
        this.item = item;
        this.CartItemID=CartItemID;
        this.quantity = quantity;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
