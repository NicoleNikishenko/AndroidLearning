package com.example.androidlearning.models;

public class Image {
    private int ID;
    private String url;

    public Image(int ID , String url) {
        this.ID = ID;
        this.url = url;
    }
    public String getUrl(){
        return url;
    }

    public int getID() {
        return ID;
    }

}
