package com.example.androidlearning.models;
import java.util.ArrayList;
import java.util.HashMap;
import mva2.adapter.ListSection;
import mva2.adapter.MultiViewAdapter;


public class FavoriteList {

    private HashMap<Integer, Image> imageList;
    private  ListSection<Image> listSection;

    public FavoriteList(ListSection<Image> listFirstSection) {
        imageList = new HashMap<>();
        this.listSection = listFirstSection;
    }


    public void addImage(Image image){
        if (imageList.get(image.getID()) != null) {
            return;
        }
        imageList.put(image.getID(),image);
        listSection.add(image);
    }


    public  ListSection<Image> getListFirstSection() {
        return listSection;
    }


    public void removeImage(int ID) {
        if (imageList.get(ID) == null){
            return;
        }
        imageList.remove(ID);
        initList();

    }
    public void initList(){
        ArrayList<Image> images = new ArrayList<>(imageList.values());
        listSection.clear();
        listSection.addAll(images);
    }

    public boolean isFavorite(int ID){
        return imageList.get(ID) != null;
    }
}
