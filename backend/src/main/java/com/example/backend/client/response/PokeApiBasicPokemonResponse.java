package com.example.backend.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokeApiBasicPokemonResponse {

    @JsonProperty("results")
    private List<PokemonEntry> entryList;

    public PokeApiBasicPokemonResponse (List<PokemonEntry> entryList) {
        this.entryList = entryList;
    }

    public PokeApiBasicPokemonResponse () {
    }

    public static class PokemonEntry {

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