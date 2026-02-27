package com.example.backend.dto;

public class AboutDTO {

    private String description;
    private String region;
    private String height;
    private String weight;

    public AboutDTO(String description, String region, String height, String weight) {
        this.description = description;
        this.region = region;
        this.height = height;
        this.weight = weight;
    }

    public AboutDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
