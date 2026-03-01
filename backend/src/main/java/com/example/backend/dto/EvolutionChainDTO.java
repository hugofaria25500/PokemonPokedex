package com.example.backend.dto;

import com.example.backend.dto.PokemonDTO;

import java.util.List;

public class EvolutionChainDTO {

    private List<EvolutionDTO> evolutionDTOList;

    public EvolutionChainDTO(List<EvolutionDTO> evolutionDTOList) {
        this.evolutionDTOList = evolutionDTOList;
    }

    public EvolutionChainDTO() {
    }

    public List<EvolutionDTO> getEvolutionDTOList() {
        return evolutionDTOList;
    }

    public void setEvolutionDTOList(List<EvolutionDTO> evolutionDTOList) {
        this.evolutionDTOList = evolutionDTOList;
    }
}
