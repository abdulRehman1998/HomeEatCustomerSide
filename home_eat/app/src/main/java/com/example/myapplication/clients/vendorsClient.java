package com.example.myapplication.clients;

import com.example.myapplication.models.Menu;
import com.example.myapplication.models.vendorModels.Vendor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface vendorsClient {

    @GET("/vendor/m/showAllVendors")
    Call<List<Vendor>> getVendors();

    @GET("/vendor/m/readMenu")
    Call<Menu> readMenu(@Header("username") String username);

}
