package com.example.backend.service;

import com.example.backend.dto.PokemonDTO;
import com.example.backend.dto.PokemonDetailDTO;

import java.util.List;

public interface PokemonService {
    PokemonDTO getPokemon(long id);
    PokemonDetailDTO getPokemonDetails(long id);
    List<PokemonDTO> getPokemons(long offset);
}
