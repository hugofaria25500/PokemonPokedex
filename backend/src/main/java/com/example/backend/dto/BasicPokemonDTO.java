package com.example.backend.dto;

public class BasicPokemonDTO {

    private String name;

    private String url;

    public BasicPokemonDTO(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public BasicPokemonDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BasicPokemonDTO{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
