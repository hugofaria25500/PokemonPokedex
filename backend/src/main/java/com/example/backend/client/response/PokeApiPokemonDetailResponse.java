package com.example.backend.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokeApiPokemonDetailResponse {

    private long id;
    private String name;
    private String imageUrl;

    private List<TypeEntry> types;

    @JsonProperty("species")
    private Description description;

    private long height;

    private long weight;

    private List<StatsEntry> stats;

    private List<Ability> abilities;

    public PokeApiPokemonDetailResponse(long id, String name, String imageUrl, List<TypeEntry> types, Description description, long height, long weight, List<StatsEntry> stats, List<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.types = types;
        this.description = description;
        this.height = height;
        this.weight = weight;
        this.stats = stats;
        this.abilities = abilities;
    }

    public PokeApiPokemonDetailResponse() {
    }

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

    public static class Description {

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class StatsEntry {
        @JsonProperty("base_stat")
        private long value;
        private Stat stat;

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public Stat getStat() {
            return stat;
        }

        public void setStat(Stat stat) {
            this.stat = stat;
        }

        public static class Stat {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class Ability {

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
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

    public List<TypeEntry> getTypes() {
        return types;
    }

    public void setTypes(List<TypeEntry> types) {this.types = types; }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setStats(List<StatsEntry> stats) {
        this.stats = stats;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public List<StatsEntry> getStats() {
        return stats;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
