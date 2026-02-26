package com.example.backend.client.response;

import com.example.backend.entity.About;
import com.example.backend.entity.Stats;

import java.util.List;

public class PokeApiPokemonDetailResponse {

    private Long id;
    private String name;
    private String imageUrl;
    private String typeUrl;

    private List<String> types;

    private About about;
    private Stats stats;

    private List<String> abilities;
    private List<EvolutionResponse> evolutionChain;
}
