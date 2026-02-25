package com.example.backend.mapper;

import com.example.backend.client.response.PokeApiPokemonResponse;
import com.example.backend.dto.PokemonDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonMapper {

    private static final String IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/";
    private static final String PNG_EXTENSION = ".png";

    public PokemonDTO toDTO(PokeApiPokemonResponse response) {

        PokemonDTO dto = new PokemonDTO();
        dto.setId(response.getId());

        String name= response.getName();
        dto.setName(capitalizePokemonName(name));

        dto.setImageUrl(buildImageUrl(response.getId()));

        dto.setTypes(
                response.getTypes()
                        .stream()
                        .map(t -> t.getType().getName())
                        .toList()
        );

        return dto;
    }

    private String buildImageUrl(long id) {
        return IMAGE_URL + id + PNG_EXTENSION;
    }

    private String capitalizePokemonName(String pokemonName) {
        return pokemonName.substring(0,1).toUpperCase() + pokemonName.substring(1);
    }
}
