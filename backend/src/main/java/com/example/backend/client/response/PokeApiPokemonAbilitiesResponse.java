package com.example.backend.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokeApiPokemonAbilitiesResponse {

    private String name;

    @JsonProperty("flavor_text_entries")
    private List<DescriptionEntry> descriptions;

    public PokeApiPokemonAbilitiesResponse(String name, List<DescriptionEntry> descriptions) {
        this.name = name;
        this.descriptions = descriptions;
    }

    public PokeApiPokemonAbilitiesResponse() {
    }

    public static class DescriptionEntry {
        private String language;

        @JsonProperty("flavor_text")
        private String description;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DescriptionEntry> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<DescriptionEntry> descriptions) {
        this.descriptions = descriptions;
    }
}
