package com.example.unique_fest_i_techno_peac.Business_package.Home_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Api_Model {

    @Expose
    @SerializedName("id")
    int id;


  /*  @Expose
    @SerializedName("name")
    String name;*/

    @Expose
    @SerializedName("image")
    String image;

    public Api_Model(int id, String image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
