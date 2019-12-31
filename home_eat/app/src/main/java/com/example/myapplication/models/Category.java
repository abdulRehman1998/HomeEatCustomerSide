package com.example.myapplication.models;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

    String name;
    String _id;

    List<Items> items;//itemsList

    public Category() {
    }

    public Category(String name, String categoryId, List<Items> items) {
        this.name = name;
        this._id = categoryId;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return _id;
    }

    public void setCategoryId(String categoryId) {
        this._id = categoryId;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
