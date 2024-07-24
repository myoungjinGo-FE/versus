package com.versus.versus.entity;

public class Snack {
    private final String Id;
    private final String Name;
    private final String imageUrl;

    public Snack(String id, String name, String imageUrl) {
        this.Id = id;
        this.Name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
