package com.example.backend.entity;

import com.example.backend.dto.PokemonDTO;

import java.util.List;

public class EvolutionChain {

    private List<PokemonDTO> pokemonEvolutionList;

    public EvolutionChain(List<PokemonDTO> pokemonEvolutionList) {
        this.pokemonEvolutionList = pokemonEvolutionList;
    }

    public EvolutionChain() {
    }

    public List<PokemonDTO> getPokemonEvolutionList() {
        return pokemonEvolutionList;
    }

    public void setPokemonEvolutionList(List<PokemonDTO> pokemonEvolutionList) {
        this.pokemonEvolutionList = pokemonEvolutionList;
    }
}
