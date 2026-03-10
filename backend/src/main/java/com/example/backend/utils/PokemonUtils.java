package com.example.backend.utils;

import com.example.backend.client.PokemonClient;
import com.example.backend.client.response.PokeApiPokemonEvolutionChainResponse;
import com.example.backend.client.response.PokeApiPokemonEvolutionResponse;
import com.example.backend.dto.EvolutionChainDTO;
import com.example.backend.dto.EvolutionDTO;
import com.example.backend.mapper.PokemonMapper;

import java.util.ArrayList;
import java.util.List;

public class PokemonUtils {

    private static final String IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/";
    private static final String PNG_EXTENSION = ".png";

    public static int POKEMON_LIMIT = 1350;

    public static int LIMIT = 50;

    public static long extractIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Long.parseLong(parts[parts.length - 1]);
    }

    public static String buildId(long id) {
        return String.format("%04d", id);
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

    public static long mapRegionToGenerationId(String region) {

        if (region == null) return 0;

        return switch (region.toLowerCase()) {
            case "kanto" -> 1;
            case "johto" -> 2;
            case "hoenn" -> 3;
            case "sinnoh" -> 4;
            case "unova" -> 5;
            case "kalos" -> 6;
            case "alola" -> 7;
            case "galar" -> 8;
            case "paldea" -> 9;
            default -> 0;
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

    public static String capitalizeText(String text) {
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }

    public static String convertMeasurestoString(long measure) {
        String str = String.valueOf(measure);
        if(str.length() == 1) {
            str = new StringBuilder(str).insert(0, "0.").toString();
        } else {
            str = new StringBuilder(str).insert(str.length() - 1, ".").toString();
        }
        return str;
    }
}
