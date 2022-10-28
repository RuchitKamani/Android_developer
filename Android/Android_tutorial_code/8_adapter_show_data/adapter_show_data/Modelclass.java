package com.example.adapter_show_data;

public class Modelclass {

    int image;
    String txt;

    public Modelclass(int image, String txt) {

        this.image=image;
        this.txt=txt;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
