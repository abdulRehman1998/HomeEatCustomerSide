package com.example.myapplication.models.vendorModels;

import com.example.myapplication.models.Menu;
import com.example.myapplication.models.Reviews;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Vendor implements Serializable {

    //min6 max10
    //cnic15

    @SerializedName("_id")
    String _id;
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("deliveryTime")
    int deliveryTime;
    @SerializedName("username")
    String username;
    @SerializedName("CNIC")
    String CNIC;
    @SerializedName("photo")
    String photo;
    @SerializedName("address")
    String address;
    @SerializedName("minOrder")
    int minOrder;
    @SerializedName("rating")
    double rating=0;//0-5
    @SerializedName("lat")
    double lat;
    @SerializedName("lon")
    double lon;
    @SerializedName("status")
    boolean status=true;
    @SerializedName("reviews")
    ArrayList<String> reviews; //id
    @SerializedName("menu")
    Menu menu;

    public Vendor(String _id, String name, String password, String username, String CNIC, String photo, String email, int deliveryTime, String address, int minOrder, double rating, double lat, double lon, boolean status, Menu menu) {
        this._id = _id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.CNIC = CNIC;
        this.photo = photo;
        this.email = email;
        this.deliveryTime = deliveryTime;
        this.address = address;
        this.minOrder = minOrder;
        this.rating = rating;
        this.lat = lat;
        this.lon = lon;
        this.status = status;
        this.menu = menu;
    }

    public Vendor(String _id, String name, String password, String username, String CNIC, String photo, int deliveryTime, String email, String address, int minOrder,  double lat, double lon, boolean status, ArrayList<String> reviews, Menu menu) {
        this._id = _id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.CNIC = CNIC;
        this.photo = photo;
        this.deliveryTime = deliveryTime;
        this.email = email;
        this.address = address;
        this.minOrder = minOrder;
        this.lat = lat;
        this.lon = lon;
        this.status = status;
        this.reviews = reviews;
        this.menu = menu;
    }

    public Vendor() {
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMinOrder() {
        return minOrder;
    }

    public void setMinOrder(int minOrder) {
        this.minOrder = minOrder;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
