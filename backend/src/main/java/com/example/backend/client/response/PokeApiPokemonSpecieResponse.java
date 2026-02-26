package com.example.backend.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokeApiPokemonSpecieResponse {

    @JsonProperty("flavor_text_entries")
    private List<DescriptionEntry> descriptions;

    private Generation generation;

    public static class DescriptionEntry {
        @JsonProperty("flavor_text")
        private String description;

        private Version version;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Version getVersion() {
            return version;
        }

        public void setVersion(Version version) {
            this.version = version;
        }
    }

    public static class Version {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Generation {

        //red, crystal, ruby
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public List<DescriptionEntry> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<DescriptionEntry> descriptions) {
        this.descriptions = descriptions;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }
}
