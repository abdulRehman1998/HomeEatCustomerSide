package com.example.myapplication.ServiceGenerator;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class servicesGenerator {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://homeeat.herokuapp.com";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null)
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

}
