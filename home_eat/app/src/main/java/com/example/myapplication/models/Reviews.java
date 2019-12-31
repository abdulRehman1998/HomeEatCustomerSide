package com.example.myapplication.models;

public class Reviews {

    String customerID;
    String vendorID;
    String createdOn;
    String reviewText;
    float rating;


    public Reviews() {
    }

    public Reviews(String customerID, String vendorID, float rating, String reviewText,String createdOn) {
        this.customerID = customerID;
        this.vendorID = vendorID;
        this.createdOn=createdOn;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
