package com.example.backend.service;

import com.example.backend.client.PokemonClient;
import com.example.backend.client.response.PokeApiPokemonDetailResponse;
import com.example.backend.client.response.PokeApiPokemonListResponse;
import com.example.backend.client.response.PokeApiPokemonResponse;
import com.example.backend.dto.PokemonDTO;
import com.example.backend.dto.PokemonDetailDTO;
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

        return mapper.toPokemonDTO(response);
    }

    @Cacheable("selectedPokemon")
    public PokemonDetailDTO getPokemonDetails(long id) {
        PokeApiPokemonDetailResponse response = client.getPokemonDetailsById(id);

        if (response == null) {
            throw new PokemonNotFoundException("Pokemon with id " + id + " not found");
        }

        return mapper.toPokemonDetailDTO(response);
    }

    @Cacheable("pokemons")
    public List<PokemonDTO> getFirstPokemons() {
        PokeApiPokemonListResponse listResponse = client.getFirstPokemons();

        if (listResponse == null) {
            throw new PokemonNotFoundException("Pokemons not found");
        }

        return listResponse.getResults()
                .parallelStream()
                .map(entry -> {

                    long id = extractIdFromUrl(entry.getUrl());

                    PokeApiPokemonResponse response =
                            client.getPokemonById(id);

                    return mapper.toPokemonDTO(response);
                })
                .toList();
    }



    private long extractIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Long.parseLong(parts[parts.length - 1]);
    }
}

