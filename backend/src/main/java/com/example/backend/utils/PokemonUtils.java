package com.example.backend.utils;

import com.example.backend.client.response.PokeApiPokemonEvolutionChainResponse;
import com.example.backend.dto.EvolutionChainDTO;
import com.example.backend.dto.EvolutionDTO;

import java.util.ArrayList;
import java.util.List;

public class PokemonUtils {

    private static final String IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/";
    private static final String PNG_EXTENSION = ".png";

    public static long extractIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Long.parseLong(parts[parts.length - 1]);
    }

    public static String mapGenerationToRegion(String generation) {

        if (generation == null) return "Unknown";

        return switch (generation.toLowerCase()) {
            case "generation-i"   -> "Kanto";
            case "generation-ii"  -> "Johto";
            case "generation-iii" -> "Hoenn";
            case "generation-iv"  -> "Sinnoh";
            case "generation-v"   -> "Unova";
            case "generation-vi"  -> "Kalos";
            case "generation-vii" -> "Alola";
            case "generation-viii"-> "Galar";
            case "generation-ix"  -> "Paldea";
            default -> "Unknown";
        };
    }

    public static String cleanFlavorText(String text) {

        if (text == null) return "";

        return text
                .replace("\n", " ")
                .replace("\f", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }

    public static String buildImageUrl(long id) {
        return IMAGE_URL + id + PNG_EXTENSION;
    }

    public static String capitalizePokemonName(String pokemonName) {
        return pokemonName.substring(0,1).toUpperCase() + pokemonName.substring(1);
    }

    public static String convertMeasurestoString(long measure) {
        String str = String.valueOf(measure);
        str = new StringBuilder(str).insert(str.length() - 1, ".").toString();
        return str;
    }

    public static void buildEvolutionList (PokeApiPokemonEvolutionChainResponse.ChainLink chainLink, List<EvolutionDTO> currentPath, List<EvolutionChainDTO> evolutionChains) {

        if (chainLink == null) return;

        currentPath.add(buildEvolutionPokemonDTOFromCurrentChainLink(chainLink));

        if (chainLink.getEvolvesTo() == null || chainLink.getEvolvesTo().isEmpty()) {

            EvolutionChainDTO chain = new EvolutionChainDTO();
            chain.setEvolutionDTOList(new ArrayList<>(currentPath));
            evolutionChains.add(chain);
            return;
        }

        for (PokeApiPokemonEvolutionChainResponse.ChainLink next : chainLink.getEvolvesTo()) {
            buildEvolutionList(next, new ArrayList<>(currentPath), evolutionChains);
        }
    }

    private static EvolutionDTO buildEvolutionPokemonDTOFromCurrentChainLink(PokeApiPokemonEvolutionChainResponse.ChainLink chainLink) {

        if(chainLink.getSpecies() == null) return null;

        String name = capitalizePokemonName(chainLink.getSpecies().getName());
        long id = extractIdFromUrl(chainLink.getSpecies().getUrl());
        String imageUrl = buildImageUrl(id);

        return new EvolutionDTO(id, name, imageUrl);
    }
}
