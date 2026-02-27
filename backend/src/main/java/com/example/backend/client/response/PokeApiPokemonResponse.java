package com.example.backend.client.response;

import java.util.List;

public class PokeApiPokemonResponse {
    private long id;
    private String name;

    private List<TypeEntry> types;

    public static class TypeEntry {
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

    public PokeApiPokemonResponse(long id, String name, List<TypeEntry> types) {
        this.id = id;
        this.name = name;
        this.types = types;
    }

    public PokeApiPokemonResponse() {
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

    public List<TypeEntry> getTypes() {return types; }

    public void setTypes(List<TypeEntry> types) {this.types = types; }
}
