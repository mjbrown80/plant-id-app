package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlantDetail {
    @JsonProperty("id")
    private int apiId;
    @JsonProperty("common_name")
    private String commonName;
    @JsonProperty("scientific_name")
    private List<String> scientificName;
    @JsonProperty("other_name")
    private List<String> alternativeName;
    private String cycle;
    private String Watering;
    private List<String> sunlight;
    @JsonProperty("original_url")
    private String imageUrl;
    @JsonProperty("thumbnail")
    private String thumbnailUrl;



    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public List<String> getScientificName() {
        return scientificName;
    }

    public void setScientificName(List<String> scientificName) {
        this.scientificName = scientificName;
    }

    public List<String> getAlternativeName() {
        return alternativeName;
    }

    public void setAlternativeName(List<String> alternativeName) {
        this.alternativeName = alternativeName;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getWatering() {
        return Watering;
    }

    public void setWatering(String watering) {
        Watering = watering;
    }

    public List<String> getSunlight() {
        return sunlight;
    }

    public void setSunlight(List<String> sunlight) {
        this.sunlight = sunlight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        return "plantDetail{" +
                ", apiId=" + apiId +
                ", commonName='" + commonName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", alternativeName='" + alternativeName + '\'' +
                ", cycle='" + cycle + '\'' +
                ", Watering='" + Watering + '\'' +
                ", sunlight='" + sunlight + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}
