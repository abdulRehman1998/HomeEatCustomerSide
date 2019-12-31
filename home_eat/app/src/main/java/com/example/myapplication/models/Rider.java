package com.example.myapplication.models;

import java.io.Serializable;

public class Rider implements Serializable {

    String name;
    String CNIC;
    String contactNumber;
    String address;
    double lat,lon;
    int totalOrders;
    int deliveredOrders;
    boolean status;//active inactive

    public Rider(String name, String CNIC, String contactNumber, String address, double lat, double lon, int totalOrders, int deliveredOrders, boolean status) {
        this.name = name;
        this.CNIC = CNIC;
        this.contactNumber = contactNumber;
        this.address = address;
        this.lat = lat;
        this.lon = lon;
        this.totalOrders = totalOrders;
        this.deliveredOrders = deliveredOrders;
        this.status = status;
    }

    public Rider() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getDeliveredOrders() {
        return deliveredOrders;
    }

    public void setDeliveredOrders(int deliveredOrders) {
        this.deliveredOrders = deliveredOrders;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}



