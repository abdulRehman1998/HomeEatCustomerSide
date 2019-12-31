package com.example.myapplication.models.customerModels;

import com.example.myapplication.models.Address;
import com.example.myapplication.models.Reviews;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {

    @SerializedName("_id")
    String _id;
    @SerializedName("username")
    String username;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("name")
    String name;
    @SerializedName("contactNumber")
    String contactNumber;
    @SerializedName("photo")
    String photo;
    @SerializedName("bannedTime")
    String banned_time;
    @SerializedName("age")
    int age;
    @SerializedName("warningCount")
    int warningCount;
    @SerializedName("banned")
    boolean banned;
    @SerializedName("creditCard")
    creditCard creditCard;
    @SerializedName("address")
    String address;


    @SerializedName("recommendation")
    ArrayList<String>  recommendation;
    @SerializedName("reviews")
    ArrayList<Reviews> reviews;


    public Customer(String username, String email, String password, String name, String contactNumber, int age, String address) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.contactNumber = contactNumber;
        this.age = age;
        this.address=address;
    }


    public Customer() {
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBanned_time() {
        return banned_time;
    }

    public void setBanned_time(String banned_time) {
        this.banned_time = banned_time;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public creditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(creditCard creditCard) {
        this.creditCard = creditCard;
    }

    public ArrayList<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Reviews> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<String> getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(ArrayList<String> recommendation) {
        this.recommendation = recommendation;
    }

    public String getAddresses() {
        return address;
    }

    public void setAddresses(String Addresses) {
        this.address = Addresses;
    }
}
