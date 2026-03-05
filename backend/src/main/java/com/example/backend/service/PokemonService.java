package com.example.backend.service;

import com.example.backend.dto.BasicPokemonDTO;
import com.example.backend.dto.PokemonDTO;
import com.example.backend.dto.PokemonDetailDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PokemonService {
    PokemonDTO getPokemon(long id);
    PokemonDetailDTO getPokemonDetails(long id);
    List<PokemonDTO> getPokemons(long offset, String searchTerm, String type, long generation, String sort);
    List<BasicPokemonDTO> getPokemonsByType(String type);
    List<BasicPokemonDTO> getBasicPokemons();
    List<BasicPokemonDTO> getBasicPokemonsByRegion();
}
