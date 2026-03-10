package com.example.backend.dto;

import java.util.List;

public class EvolutionDTO {

    private String id;
    private String name;
    private String imageUrl;

    private List<String> types;

    public EvolutionDTO() {
    }

    public EvolutionDTO(String id, String name, String imageUrl, List<String> types) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.types = types;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "EvolutionDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", types=" + types +
                '}';
    }
}
