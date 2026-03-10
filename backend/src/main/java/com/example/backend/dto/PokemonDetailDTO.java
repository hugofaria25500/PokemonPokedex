package com.example.backend.dto;

import java.util.List;

public class PokemonDetailDTO {

    private String id;
    private String name;
    private String imageUrl;

    private List<String> types;

    private AboutDTO about;

    private List<StatDTO> statList;

    private List<AbilitiyDTO> abilityList;

    private List<EvolutionChainDTO> evolutionChainList;

    public PokemonDetailDTO(String id, String name, String imageUrl, List<String> types, AboutDTO about, List<StatDTO> statList, List<AbilitiyDTO> abilityList, List<EvolutionChainDTO> evolutionChainList) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.types = types;
        this.about = about;
        this.statList = statList;
        this.abilityList = abilityList;
        this.evolutionChainList = evolutionChainList;
    }

    public PokemonDetailDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public AboutDTO getAbout() {
        return about;
    }

    public void setAbout(AboutDTO about) {
        this.about = about;
    }

    public List<StatDTO> getStatList() {
        return statList;
    }

    public void setStatList(List<StatDTO> statList) {
        this.statList = statList;
    }

    public List<AbilitiyDTO> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(List<AbilitiyDTO> abilityList) {
        this.abilityList = abilityList;
    }

    public List<EvolutionChainDTO> getEvolutionChainList() {
        return evolutionChainList;
    }

    public void setEvolutionChainList(List<EvolutionChainDTO> evolutionChainList) {
        this.evolutionChainList = evolutionChainList;
    }

    @Override
    public String toString() {
        return "PokemonDetailDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", types=" + types +
                ", about=" + about +
                ", statList=" + statList +
                ", abilityList=" + abilityList +
                ", evolutionChainList=" + evolutionChainList +
                '}';
    }
}
