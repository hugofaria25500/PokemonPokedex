package com.example.backend.service;

import com.example.backend.client.PokemonClient;
import com.example.backend.client.response.PokeApiPokemonResponse;
import com.example.backend.dto.PokemonDTO;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private final PokemonClient client;

    public PokemonService(PokemonClient client) {
        this.client = client;
    }

    public PokemonDTO getPokemon(long id) {

        PokeApiPokemonResponse response = client.getPokemonById(id);

        PokemonDTO dto = new PokemonDTO();
        dto.setId(response.getId());
        dto.setName(response.getName());
        dto.setImageUrl(response.getImageUrl());

        return dto;
    }
}

