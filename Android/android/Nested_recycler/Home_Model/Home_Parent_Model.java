package com.example.unique_fest_i_techno_peac.Business_package.Home_Model;

import java.util.List;

public class Home_Parent_Model {


    String txt_PARENT;
    public List<Api_Model> home_chaild_models;

    public Home_Parent_Model(String txt_PARENT, List<Api_Model> home_chaild_models) {
        this.txt_PARENT = txt_PARENT;
        this.home_chaild_models = home_chaild_models;
    }

    public String getTxt_PARENT() {
        return txt_PARENT;
    }

    public void setTxt_PARENT(String txt_PARENT) {
        this.txt_PARENT = txt_PARENT;
    }

    public List<Api_Model> getHome_chaild_models() {
        return home_chaild_models;
    }

    public void setHome_chaild_models(List<Api_Model> home_chaild_models) {
        this.home_chaild_models = home_chaild_models;
    }
}
