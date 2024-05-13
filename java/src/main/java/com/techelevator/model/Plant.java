package com.techelevator.model;

public class Plant {
    private int id;
    private String name;
    private String imageUrl;

    public Plant(int id, String imageUrl, String name) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Plant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return imageUrl;
    }

    public void setUrl(String ImageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + imageUrl + '\'' +
                '}';
    }
}
