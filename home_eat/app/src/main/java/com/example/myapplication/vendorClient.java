package com.example.myapplication;

import com.example.myapplication.models.vendorModels.Vendor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface vendorClient {

    @GET("/")
    Call<List<Vendor>> getVendorData();



}
