package com.example.backend.client.response;

import java.util.List;

public class PokeApiPokemonSpecieResponse {

    private List<PokemonDescriptionEntry> descriptions;

    private String generation;

    public static class PokemonDescriptionEntry {
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public List<PokemonDescriptionEntry> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<PokemonDescriptionEntry> descriptions) {
        this.descriptions = descriptions;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }
}
