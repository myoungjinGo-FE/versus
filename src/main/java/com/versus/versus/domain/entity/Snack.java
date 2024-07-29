package com.versus.versus.domain.entity;

public class Snack {


    private Integer Id;
    private String Name;
    private String imageUrl;

    public Snack(Integer id, String name, String imageUrl) {
        this.Id = id;
        this.Name = name;
        this.imageUrl = imageUrl;
    }

    public Snack(){

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

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
