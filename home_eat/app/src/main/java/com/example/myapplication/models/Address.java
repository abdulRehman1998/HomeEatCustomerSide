package com.example.myapplication.models;

public class Address {

    String _id, houseNumber, area, city, street;
    double lat, lon;
    boolean def;


    public Address(String _id, String houseNumber, String area, String city, String street, double lat, double lon, boolean def) {
        this._id = _id;
        this.houseNumber = houseNumber;
        this.area = area;
        this.city = city;
        this.street = street;
        this.lat = lat;
        this.lon = lon;
        this.def = def;
    }

    public Address() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public boolean isDef() {
        return def;
    }

    public void setDef(boolean def) {
        this.def = def;
    }
}
