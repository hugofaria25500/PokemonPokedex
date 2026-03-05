package com.example.backend.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokeApiPokemonByRegionResponse {

    @JsonProperty("pokemon_species")
    private List<PokemonEntry> entryList;

    public PokeApiPokemonByRegionResponse (List<PokemonEntry> entryList) {
        this.entryList = entryList;
    }

    public PokeApiPokemonByRegionResponse () {
    }

    public static class PokemonEntry {

        private Pokemon pokemon;

        public Pokemon getPokemon() {
            return pokemon;
        }

        public void setPokemon(Pokemon pokemon) {
            this.pokemon = pokemon;
        }
    }

    public static class Pokemon {

        private String name;

        private String url;

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
    }

    public List<PokemonEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<PokemonEntry> entryList) {
        this.entryList = entryList;
    }
}
