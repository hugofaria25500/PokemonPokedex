package com.example.backend.dto;

import java.util.List;

public class EvolutionChainDTO {

    private List<EvolutionDTO> evolutionList;

    public EvolutionChainDTO(List<EvolutionDTO> evolutionList) {
        this.evolutionList = evolutionList;
    }

    public EvolutionChainDTO() {
    }

    public List<EvolutionDTO> getEvolutionList() {
        return evolutionList;
    }

    public void setEvolutionList(List<EvolutionDTO> evolutionList) {
        this.evolutionList = evolutionList;
    }
}
