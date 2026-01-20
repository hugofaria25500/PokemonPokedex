package com.example.backend.client.response;

public class PokeApiPokemonResponse {
    private long id;
    private String name;
    private String imageUrl;

    public PokeApiPokemonResponse() {
    }
    
    public PokeApiPokemonResponse(long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
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
}
