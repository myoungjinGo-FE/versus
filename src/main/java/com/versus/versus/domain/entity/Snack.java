package com.versus.versus.domain.entity;

public class Snack {


    private final Integer Id;
    private final String Name;
    private final String imageUrl;

    public Snack(Integer id, String name, String imageUrl) {
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

    public Integer getId() {
        return Id;
    }
}
