package com.example.myapplication.models;

import java.io.Serializable;

public class Items implements Serializable {

    String _id, name, desc;
    int totalSold=0;
    double predictedSales=0;
    int price;

    public Items() {
    }


    public Items(String _id, String name, String desc, int totalSold, int price, double predictedSales) {
        this._id = _id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.predictedSales=predictedSales;
        this.totalSold=totalSold;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPredictedSales() {
        return predictedSales;
    }

    public void setPredictedSales(double predictedSales) {
        this.predictedSales = predictedSales;
    }
}
