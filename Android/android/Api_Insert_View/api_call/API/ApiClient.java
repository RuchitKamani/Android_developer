package com.example.api_call.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    static Retrofit retrofit = null;
    public static final String BASE_URL1 = "https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/";
    public static final String BASE_URL = "https://topsandroid.000webhostapp.com/english_class/connect/";
    public static Retrofit getapiclient()
    {
        retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        return retrofit;
    }
}
