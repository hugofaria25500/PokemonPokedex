package com.example.backend.dto;

import com.example.backend.dto.PokemonDTO;

import java.util.List;

public class EvolutionChainDTO {

    private List<PokemonDTO> pokemonEvolutionList;

    public EvolutionChainDTO(List<PokemonDTO> pokemonEvolutionList) {
        this.pokemonEvolutionList = pokemonEvolutionList;
    }

    public EvolutionChainDTO() {
    }

    public List<PokemonDTO> getPokemonEvolutionList() {
        return pokemonEvolutionList;
    }

    public void setPokemonEvolutionList(List<PokemonDTO> pokemonEvolutionList) {
        this.pokemonEvolutionList = pokemonEvolutionList;
    }
}
