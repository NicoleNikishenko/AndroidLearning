package com.example.androidlearning.repositories;

import com.example.androidlearning.models.Image;

import java.util.ArrayList;

public class ImageListRepository {
    private int imageCount = 0;

    public ArrayList<Image> getImages(){
        int arraySize = imageCount + 40;
        ArrayList<Image> images = new ArrayList<>();
        for (int i = imageCount ; i < arraySize ; i++) {
            Image image = new Image(i ,"https://picsum.photos/900?temp="+i);
            imageCount++;
            images.add(image);
        }
        return images;
    }
}
