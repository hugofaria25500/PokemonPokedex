package com.example.backend.dto;

import java.util.List;

public class PokemonDetailDTO {

    private long id;
    private String name;
    private String imageUrl;

    private List<String> types;

    private AboutDTO aboutDTO;

    private List<StatDTO> statDTOList;

    private List<AbilitiyDTO> abilitiyDTOList;

    private List<EvolutionChainDTO> evolutionChainDTOS;

    public PokemonDetailDTO(long id, String name, String imageUrl, List<String> types, AboutDTO aboutDTO, List<StatDTO> statDTOList, List<AbilitiyDTO> abilitiyDTOList, List<EvolutionChainDTO> evolutionChainDTOS) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.types = types;
        this.aboutDTO = aboutDTO;
        this.statDTOList = statDTOList;
        this.abilitiyDTOList = abilitiyDTOList;
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

    public List<StatDTO> getStatDTOList() {
        return statDTOList;
    }

    public void setStatDTOList(List<StatDTO> statDTOList) {
        this.statDTOList = statDTOList;
    }

    public List<AbilitiyDTO> getAbilitiyDTOList() {
        return abilitiyDTOList;
    }

    public void setAbilitiyDTOList(List<AbilitiyDTO> abilitiyDTOList) {
        this.abilitiyDTOList = abilitiyDTOList;
    }

    public List<EvolutionChainDTO> getEvolutionChainDTOS() {
        return evolutionChainDTOS;
    }

    public void setEvolutionChainDTOS(List<EvolutionChainDTO> evolutionChainDTOS) {
        this.evolutionChainDTOS = evolutionChainDTOS;
    }

    public List<EvolutionChainDTO> getEvolutionChains() {
        return evolutionChainDTOS;
    }

    public void setEvolutionChains(List<EvolutionChainDTO> evolutionChainDTOS) {
        this.evolutionChainDTOS = evolutionChainDTOS;
    }
}
