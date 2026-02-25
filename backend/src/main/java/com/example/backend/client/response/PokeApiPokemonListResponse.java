package com.example.backend.client.response;

import java.util.List;

public class PokeApiPokemonListResponse {

    private List<PokemonEntry> results;

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

    public List<PokemonEntry> getResults() {
        return results;
    }

    public void setResults(List<PokemonEntry> results) {
        this.results = results;
    }
}
