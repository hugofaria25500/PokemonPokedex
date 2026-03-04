package com.example.backend.service;

import com.example.backend.dto.PokemonDTO;
import com.example.backend.dto.PokemonDetailDTO;

import java.util.List;

public interface PokemonService {
    public PokemonDTO getPokemon(long id);
    public PokemonDetailDTO getPokemonDetails(long id);
    public List<PokemonDTO> getPokemons(long offset);
}
