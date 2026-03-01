package com.example.backend.mapper;

import com.example.backend.client.response.PokeApiPokemonDetailResponse;
import com.example.backend.client.response.PokeApiPokemonResponse;
import com.example.backend.client.response.PokeApiPokemonSpecieResponse;
import com.example.backend.dto.AboutDTO;
import com.example.backend.dto.PokemonDTO;
import com.example.backend.dto.PokemonDetailDTO;
import com.example.backend.dto.StatsDTO;
import org.springframework.stereotype.Component;

@Component
public class PokemonMapper {

    private static final String IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/";
    private static final String PNG_EXTENSION = ".png";



    public PokemonDTO toPokemonDTO(PokeApiPokemonResponse response) {

        PokemonDTO dto = new PokemonDTO();
        dto.setId(response.getId());

        String name= response.getName();
        dto.setName(capitalizePokemonName(name));

        dto.setImageUrl(buildImageUrl(response.getId()));

        dto.setTypes(
                response.getTypes()
                        .stream()
                        .map(typeEntry -> typeEntry.getType().getName())
                        .toList()
        );

        return dto;
    }

    public PokemonDetailDTO toPokemonDetailDTO(PokeApiPokemonDetailResponse response, PokeApiPokemonSpecieResponse specieResponse) {

        //BASIC DETAILS
        PokemonDetailDTO pokemonDTO = new PokemonDetailDTO();

        pokemonDTO.setId(response.getId());

        String name= response.getName();
        pokemonDTO.setName(name != null ? capitalizePokemonName(name) : "");

        pokemonDTO.setImageUrl(buildImageUrl(response.getId()));

        pokemonDTO.setTypes(
                response.getTypes()
                        .stream()
                        .map(typeEntry -> typeEntry.getType().getName())
                        .toList()
        );

        //ABOUT DETAILS
        AboutDTO aboutDTO = new AboutDTO();

        aboutDTO.setHeight(convertMeasurestoString(response.getHeight()));
        aboutDTO.setWeight(convertMeasurestoString(response.getWeight()));

        if(specieResponse != null) {
            StringBuilder sb = new StringBuilder();
            specieResponse.getDescriptions().forEach(descriptionEntry -> {
                if("red".equals(descriptionEntry.getVersion().getName()) || "gold".equals(descriptionEntry.getVersion().getName())) {
                    sb.append(descriptionEntry.getDescription());
                }
            });
            aboutDTO.setDescription(cleanFlavorText(sb.toString()));
            aboutDTO.setRegion(mapGenerationToRegion(specieResponse.getGeneration().getName()));
        }



        pokemonDTO.setAboutDTO(aboutDTO);

        //STATS DETAILS
        StatsDTO statsDTO = new StatsDTO();

        if (response.getStats() != null) { {
            response.getStats().forEach(statsEntry -> {

                switch (statsEntry.getStat().getName()) {
                    case "hp" -> statsDTO.setHp(statsEntry.getValue());
                    case "attack" -> statsDTO.setAttack(statsEntry.getValue());
                    case "defense" -> statsDTO.setDefense(statsEntry.getValue());
                    case "special-attack" -> statsDTO.setSpecialAttack(statsEntry.getValue());
                    case "special-defense" -> statsDTO.setSpecialDefense(statsEntry.getValue());
                    case "speed" -> statsDTO.setSpeed(statsEntry.getValue());
                }
            });
        }}

        pokemonDTO.setStats(statsDTO);

        //ABILITIES DETAILS

        //EVOLUTION CHAIN DETAILS



        return pokemonDTO;

    }

    private String buildImageUrl(long id) {
        return IMAGE_URL + id + PNG_EXTENSION;
    }

    private String capitalizePokemonName(String pokemonName) {
        return pokemonName.substring(0,1).toUpperCase() + pokemonName.substring(1);
    }

    private String convertMeasurestoString(long measure) {
        String str = String.valueOf(measure);
        str = new StringBuilder(str).insert(str.length()-1, ".").toString();
        return str;
    }

    private String mapGenerationToRegion(String generation) {

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

    private String cleanFlavorText(String text) {

        if (text == null) return "";

        return text
                .replace("\n", " ")
                .replace("\f", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }
}
