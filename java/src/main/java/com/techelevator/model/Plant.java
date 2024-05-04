package com.techelevator.model;

public class Plant {
    private int id;
    private String name;
    private String imageUrl;

    public Plant(int id,String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
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
