package com.example.api_call.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Apiinterface {
    @FormUrlEncoded
    @POST("insert.php")
    Call<Void>productadd(
            @Field("name")  String name,
            @Field("number")  String number,
            @Field("email") String email,
            @Field("password") String password
    );
    @GET("view.php")
    Call<List<Model>> productview();
}
