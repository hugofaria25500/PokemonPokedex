package com.example.backend.client.response;

import java.util.List;

public class PokeApiPokemonResponse {
    private long id;
    private String name;
    private String imageUrl;

    private List<TypeWrapper> types;

    public static class TypeWrapper {
        private Type type;

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }
    }

    public static class Type {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public PokeApiPokemonResponse() {
    }
    
    public PokeApiPokemonResponse(long id, String name, String imageUrl, List<TypeWrapper> types) {
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

    public List<TypeWrapper> getTypes() {return types; }

    public void setTypes(List<TypeWrapper> types) {this.types = types; }
}
