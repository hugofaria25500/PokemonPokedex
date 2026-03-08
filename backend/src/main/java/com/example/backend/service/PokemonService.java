package com.example.backend.service;

import com.example.backend.dto.BasicPokemonDTO;
import com.example.backend.dto.PokemonDTO;
import com.example.backend.dto.PokemonDetailDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PokemonService {
    PokemonDTO getPokemon(long id);
    PokemonDetailDTO getPokemonDetails(long id);
    List<PokemonDTO> getPokemons(int offset, String searchTerm, String type, String region, String sort);
    List<BasicPokemonDTO> getBasicPokemonsByType(String type);
    List<BasicPokemonDTO> getBasicPokemonsByRegion(String region);
    List<BasicPokemonDTO> getFilteredPokemons(int offset, String searchTerm, String type, String region, String sort);
}
