package com.example.backend.dto;

import java.util.List;

public class PokemonDTO {

    private long id;
    private String name;
    private String imageUrl;

    private List<String> types;

    public PokemonDTO() {
    }

    public PokemonDTO(long id, String name, String imageUrl, List<String> types) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.types = types;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
