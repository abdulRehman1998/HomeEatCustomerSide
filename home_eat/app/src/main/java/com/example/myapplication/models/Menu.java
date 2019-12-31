package com.example.myapplication.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Menu implements Serializable {

    String _id;
    ArrayList<Category> category;


    public Menu() {
    }

    public Menu(ArrayList<Category> menuList) {
        this.category = menuList;
    }

    public ArrayList<Category> getcategoriesList() {
        return category;
    }

    public void setMenuList(ArrayList<Category> categories) {
        this.category = categories;
    }
}
