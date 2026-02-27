package com.example.backend.dto;

import java.util.List;

public class PokemonDetailDTO {

    private long id;
    private String name;
    private String imageUrl;

    private List<String> types;

    private AboutDTO aboutDTO;

    private StatsDTO statsDTO;

    private List<AbilitiesDTO> abilitiesDTO;

    private List<EvolutionChainDTO> evolutionChainDTOS;

    public PokemonDetailDTO(long id, String name, String imageUrl, List<String> types, AboutDTO aboutDTO, StatsDTO statsDTO, List<AbilitiesDTO> abilitiesDTO, List<EvolutionChainDTO> evolutionChainDTOS) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.types = types;
        this.aboutDTO = aboutDTO;
        this.statsDTO = statsDTO;
        this.abilitiesDTO = abilitiesDTO;
        this.evolutionChainDTOS = evolutionChainDTOS;
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

    public AboutDTO getAboutDTO() {
        return aboutDTO;
    }

    public void setAboutDTO(AboutDTO aboutDTO) {
        this.aboutDTO = aboutDTO;
    }

    public StatsDTO getStats() {
        return statsDTO;
    }

    public void setStats(StatsDTO statsDTO) {
        this.statsDTO = statsDTO;
    }

    public List<AbilitiesDTO> getAbilitiesDTO() {
        return abilitiesDTO;
    }

    public void setAbilitiesDTO(List<AbilitiesDTO> abilitiesDTO) {
        this.abilitiesDTO = abilitiesDTO;
    }

    public List<EvolutionChainDTO> getEvolutionChains() {
        return evolutionChainDTOS;
    }

    public void setEvolutionChains(List<EvolutionChainDTO> evolutionChainDTOS) {
        this.evolutionChainDTOS = evolutionChainDTOS;
    }
}
