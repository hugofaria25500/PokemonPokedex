package com.example.backend.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokeApiPokemonEvolutionChainResponse {

    @JsonProperty("chain")
    private ChainLink chainLink;

    public PokeApiPokemonEvolutionChainResponse(ChainLink chainLink) {
        this.chainLink = chainLink;
    }

    public PokeApiPokemonEvolutionChainResponse() {
    }

    public static class ChainLink {
        private Species species;
        private List<ChainLink> evolvesTo;

        public Species getSpecies() {
            return species;
        }

        public void setSpecies(Species species) {
            this.species = species;
        }

        public List<ChainLink> getEvolvesTo() {
            return evolvesTo;
        }

        public void setEvolvesTo(List<ChainLink> evolvesTo) {
            this.evolvesTo = evolvesTo;
        }
    }

    public static class Species {
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

    public ChainLink getChainLink() {
        return chainLink;
    }

    public void setChainLink(ChainLink chainLink) {
        this.chainLink = chainLink;
    }
}
