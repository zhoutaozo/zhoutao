package com.example.testapplication;

public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name,int fruitImage) {
        this.name = name;
        this.imageId = fruitImage;
    }

    public String getName() { return name; }
    public int getImageId() { return imageId; }
}
