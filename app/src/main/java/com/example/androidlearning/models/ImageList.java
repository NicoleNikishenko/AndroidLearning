package com.example.androidlearning.models;

import java.util.ArrayList;

public class ImageList {

    private ArrayList<Image> images;


    public ImageList( ArrayList<Image> images) {
        this.images = images;
    }

    public ArrayList<Image> getImages() {
        return images;
    }
}
