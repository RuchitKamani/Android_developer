package com.example.api_call.API;

import com.example.api_call.image_model;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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
