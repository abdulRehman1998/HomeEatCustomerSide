package com.example.myapplication.clients;

import com.example.myapplication.models.customerModels.Customer;
import com.example.myapplication.models.vendorModels.Vendor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface customerClient {


    //login
    @FormUrlEncoded
    @POST("/vendor/m/LoginVendor")
    Call<Customer> LogIn(@Field("username") String username, @Field("password") String password);


    @FormUrlEncoded
    @POST("/customer/m/addCustomer")
    Call<Customer> SignUp(@Body Customer customer);



    /*@GET("/vendor/m/readMenu")
    Call<Menu> readMenu(@Header("username") String username);

    @POST("/vendor/m/addVendorMenu")
    Call<Menu> CreateMenu(@Body SendingMenu sendingMenu);
*/



}
