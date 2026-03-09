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

    public PokeApiPokemonListResponse getPokemons(long offset) {
        return webClient.get()
                .uri("/pokemon?limit=50&offset={offset}", offset)
                .retrieve()
                .bodyToMono(PokeApiPokemonListResponse.class)
                .retry(3)
                .block();
    }

    public PokeApiPokemonResponse getPokemonById(long id) {
        return webClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonResponse.class)
                .retry(3)
                .block();
    }

    public PokeApiPokemonDetailResponse getPokemonDetailsById(long id) {
        return webClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonDetailResponse.class)
                .retry(3)
                .block();
    }

    public PokeApiPokemonSpecieResponse getPokemonSpeciesById(long id) {
        return webClient.get()
                .uri("/pokemon-species/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonSpecieResponse.class)
                .retry(3)
                .block();
    }

    public PokeApiPokemonAbilitiesResponse getPokemonAbilitiesById(long id) {
        return webClient.get()
                .uri("/ability/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonAbilitiesResponse.class)
                .retry(3)
                .block();
    }

    public PokeApiPokemonEvolutionChainResponse getPokemonEvolutionChainById(long id) {
        return webClient.get()
                .uri("/evolution-chain/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonEvolutionChainResponse.class)
                .retry(3)
                .block();
    }

    public PokeApiPokemonEvolutionResponse getPokemonEvolutionById(long id) {
        return webClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonEvolutionResponse.class)
                .retry(3)
                .block();
    }

    public PokeApiPokemonByTypeResponse getBasicPokemonListByType(String type) {
        return webClient.get()
                .uri("/type/{type}", type)
                .retrieve()
                .bodyToMono(PokeApiPokemonByTypeResponse.class)
                .retry(3)
                .block();
    }

    public PokeApiPokemonByRegionResponse getBasicPokemonListByRegion(long id) {
        return webClient.get()
                .uri("/generation/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonByRegionResponse.class)
                .retry(3)
                .block();
    }

    public PokeApiBasicPokemonResponse getBasicPokemonList() {
        return webClient.get()
                .uri("/pokemon/?limit=2000")
                .retrieve()
                .bodyToMono(PokeApiBasicPokemonResponse.class)
                .retry(3)
                .block();
    }
}

