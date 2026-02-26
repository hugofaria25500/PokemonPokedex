package com.example.backend.dto;

import com.example.backend.entity.Abilities;
import com.example.backend.entity.About;
import com.example.backend.entity.EvolutionChain;
import com.example.backend.entity.Stats;

import java.util.List;

public class PokemonDetailDTO {

    private long id;
    private String name;
    private String imageUrl;

    private List<String> types;

    private About info;

    private Stats stats;

    private List<Abilities> abilities;

    private List<EvolutionChain> evolutionChains;

    public PokemonDetailDTO(long id, String name, String imageUrl, List<String> types, About info, Stats stats, List<Abilities> abilities, List<EvolutionChain> evolutionChains) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.types = types;
        this.info = info;
        this.stats = stats;
        this.abilities = abilities;
        this.evolutionChains = evolutionChains;
    }

    public PokemonDetailDTO() {
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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public About getInfo() {
        return info;
    }

    public void setInfo(About info) {
        this.info = info;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<EvolutionChain> getEvolutionChains() {
        return evolutionChains;
    }

    public void setEvolutionChains(List<EvolutionChain> evolutionChains) {
        this.evolutionChains = evolutionChains;
    }
}
