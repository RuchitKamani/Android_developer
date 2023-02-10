package com.example.api_call.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {
    @Expose
    @SerializedName("id")
    int id;

    @Expose
    @SerializedName("name")
    String name;

    @Expose
    @SerializedName("number")
    String number;

    @Expose
    @SerializedName("email")
    String email;

    @Expose
    @SerializedName("password")
    String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
