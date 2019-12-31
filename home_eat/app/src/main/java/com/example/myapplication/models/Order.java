package com.example.myapplication.models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "orderTable")
public class Order implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "orderID")
    String orderId;
    @ColumnInfo(name = "vendorID")
    String vendorID;
    @ColumnInfo(name = "customerID")
    String customerID;
    @ColumnInfo(name = "time")
    String time;
    @ColumnInfo(name = "date")
    String date;
    @ColumnInfo(name = "totalPrice")
    float totalPrice;
    @ColumnInfo(name = "deliveryFee")
    float deliveryFee;
    //accepted rejected canceled prepared onWay delivered
    @ColumnInfo(name = "deliveryStatus")
    String deliveryStatus;
    @ColumnInfo(name = "tax")
    float tax;
    @ColumnInfo(name = "arrayCart")
    ArrayList<CartItem> cartItemArrayList =new ArrayList<CartItem>();

    public Order() {
    }

    public Order(String orderID,String vendorID, String customerID, String time, String date, float totalPrice, float deliveryFee, String deliveryStatus, float tax, ArrayList<CartItem> cartItemArrayList) {
        this.orderId=orderID;
        this.vendorID = vendorID;
        this.customerID = customerID;
        this.time = time;
        this.date = date;
        this.totalPrice = totalPrice;
        this.deliveryFee = deliveryFee;
        this.deliveryStatus = deliveryStatus;
        this.tax = tax;
        this.cartItemArrayList = cartItemArrayList;
    }

    public void addCartItem(CartItem cartItem)
    {
        cartItemArrayList.add(cartItem);
    }

    public void addPrice(int price)
    {
        this.totalPrice=this.totalPrice+price;
    }

    @NonNull
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(@NonNull String orderId) {
        this.orderId = orderId;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public ArrayList<CartItem> getCartItemArrayList() {
        return cartItemArrayList;
    }

    public void setCartItemArrayList(ArrayList<CartItem> cartItemArrayList) {
        this.cartItemArrayList = cartItemArrayList;
    }
}
