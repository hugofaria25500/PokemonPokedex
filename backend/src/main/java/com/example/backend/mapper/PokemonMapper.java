package com.example.backend.mapper;

import com.example.backend.client.response.PokeApiPokemonDetailResponse;
import com.example.backend.client.response.PokeApiPokemonResponse;
import com.example.backend.client.response.PokeApiPokemonSpecieResponse;
import com.example.backend.dto.*;
import com.example.backend.utils.PokemonUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonMapper {

    public PokemonDTO toPokemonDTO(PokeApiPokemonResponse response) {

        PokemonDTO dto = new PokemonDTO();
        dto.setId(response.getId());

        String name= response.getName();
        dto.setName(PokemonUtils.capitalizePokemonName(name));

        dto.setImageUrl(PokemonUtils.buildImageUrl(response.getId()));

        dto.setTypes(
                response.getTypes()
                        .stream()
                        .map(typeEntry -> typeEntry.getType().getName())
                        .toList()
        );

        return dto;
    }

    public PokemonDetailDTO toPokemonDetailDTO(PokeApiPokemonDetailResponse response,
                                               PokeApiPokemonSpecieResponse specieResponse,
                                               List<AbilitiyDTO> abilitiyDTOList,
                                               List<EvolutionChainDTO> evolutionChainDTOList) {

        //BASIC DETAILS
        PokemonDetailDTO pokemonDTO = new PokemonDetailDTO();

        pokemonDTO.setId(response.getId());

        String name= response.getName();
        pokemonDTO.setName(name != null ? PokemonUtils.capitalizePokemonName(name) : "");

        pokemonDTO.setImageUrl(PokemonUtils.buildImageUrl(response.getId()));

        pokemonDTO.setTypes(
                response.getTypes()
                        .stream()
                        .map(typeEntry -> typeEntry.getType().getName())
                        .toList()
        );

        //ABOUT DETAILS
        AboutDTO aboutDTO = new AboutDTO();

        aboutDTO.setHeight(PokemonUtils.convertMeasurestoString(response.getHeight()));
        aboutDTO.setWeight(PokemonUtils.convertMeasurestoString(response.getWeight()));

        if(specieResponse != null) {
            StringBuilder sb = new StringBuilder();
            specieResponse.getDescriptions().forEach(descriptionEntry -> {
                if("red".equals(descriptionEntry.getVersion().getName()) || "gold".equals(descriptionEntry.getVersion().getName())) {
                    sb.append(PokemonUtils.capitalizeText(descriptionEntry.getDescription().toLowerCase()));
                }
            });
            aboutDTO.setDescription(PokemonUtils.cleanFlavorText(sb.toString()));
            aboutDTO.setRegion(PokemonUtils.mapGenerationToRegion(specieResponse.getGeneration().getName()));
        }

        pokemonDTO.setAboutDTO(aboutDTO);

        //STATS DETAILS
        List<StatDTO> statDTOList = response.getStats()
                .stream()
                .map(statsEntry -> new StatDTO(statsEntry.getStat().getName(), statsEntry.getValue())).toList();


        pokemonDTO.setStatDTOList(statDTOList);

        //ABILITIES DETAILS
        pokemonDTO.setAbilitiyDTOList(abilitiyDTOList);

        //EVOLUTION CHAIN DETAILS
        pokemonDTO.setEvolutionChainDTOList(evolutionChainDTOList);

        return pokemonDTO;

    }
}
