package com.example.backend.client;

import com.example.backend.client.response.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PokemonClient {

    private final WebClient webClient;

    public PokemonClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public PokeApiPokemonListResponse getFirstPokemons() {
        return webClient.get()
                .uri("/pokemon?limit=50&offset=0")
                .retrieve()
                .bodyToMono(PokeApiPokemonListResponse.class)
                .block();
    }

    public PokeApiPokemonResponse getPokemonById(long id) {
        return webClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonResponse.class)
                .block();
    }

    public PokeApiPokemonDetailResponse getPokemonDetailsById(long id) {
        return webClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonDetailResponse.class)
                .block();
    }

    public PokeApiPokemonSpecieResponse getPokemonSpeciesById(long id) {
        return webClient.get()
                .uri("/pokemon-species/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonSpecieResponse.class)
                .block();
    }

    public PokeApiPokemonAbilitiesResponse getPokemonAbilitiesById(long id) {
        return webClient.get()
                .uri("/ability/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonAbilitiesResponse.class)
                .block();
    }

    public PokeApiPokemonEvolutionChainResponse getPokemonEvolutionChainById(long id) {
        return webClient.get()
                .uri("/evolution-chain/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonEvolutionChainResponse.class)
                .block();
    }
}

