package com.example.backend.client;

import com.example.backend.client.response.PokeApiPokemonListResponse;
import com.example.backend.client.response.PokeApiPokemonResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PokemonClient {

    private final WebClient webClient;

    public PokemonClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public PokeApiPokemonResponse getPokemonById(long id) {
        return webClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .bodyToMono(PokeApiPokemonResponse.class)
                .block();
    }

    public PokeApiPokemonListResponse getPokemonAllPokemons() {
        return webClient.get()
                .uri("/pokemon?limit=30&offset=0")
                .retrieve()
                .bodyToMono(PokeApiPokemonListResponse.class)
                .block();
    }
}

