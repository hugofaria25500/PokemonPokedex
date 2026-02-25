package com.example.backend.service;

import com.example.backend.client.PokemonClient;
import com.example.backend.client.response.PokeApiPokemonListResponse;
import com.example.backend.client.response.PokeApiPokemonResponse;
import com.example.backend.dto.PokemonDTO;
import com.example.backend.exception.PokemonNotFoundException;
import com.example.backend.mapper.PokemonMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonClient client;

    private final PokemonMapper mapper;

    public PokemonService(PokemonClient client, PokemonMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Cacheable("pokemon")
    public PokemonDTO getPokemon(long id) {
        PokeApiPokemonResponse response = client.getPokemonById(id);

        if (response == null) {
            throw new PokemonNotFoundException("Pokemon with id " + id + " not found");
        }

        return mapper.toDTO(response);
    }

    @Cacheable("pokemons")
    public List<PokemonDTO> getAllPokemons() {
        PokeApiPokemonListResponse listResponse = client.getPokemonAllPokemons();

        if (listResponse == null) {
            throw new PokemonNotFoundException("Pokemons not found");
        }

        return listResponse.getResults()
                .parallelStream()
                .map(entry -> {

                    long id = extractIdFromUrl(entry.getUrl());

                    PokeApiPokemonResponse detail =
                            client.getPokemonById(id);

                    return mapper.toDTO(detail);
                })
                .toList();
    }

    private long extractIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Long.parseLong(parts[parts.length - 1]);
    }
}

