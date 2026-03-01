package com.example.backend.service;

import com.example.backend.client.PokemonClient;
import com.example.backend.client.response.*;
import com.example.backend.dto.*;
import com.example.backend.exception.PokemonNotFoundException;
import com.example.backend.mapper.PokemonMapper;
import com.example.backend.utils.PokemonUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        PokeApiPokemonSpecieResponse specieResponse = client.getPokemonSpeciesById(PokemonUtils.extractIdFromUrl(response.getDescription().getUrl()));
        long evolutionChainId = PokemonUtils.extractIdFromUrl(specieResponse.getEvolutionChain().getEvolutionChainUrl());


        List<AbilitiyDTO> abilitiyDTOList = response.getAbilities()
            .stream()
            .map(abilityEntry -> {

                PokeApiPokemonAbilitiesResponse abilitiesResponse =
                        client.getPokemonAbilitiesById(
                                PokemonUtils.extractIdFromUrl(abilityEntry.getAbility().getUrl())
                        );

                String name = abilitiesResponse.getName();

                String description = abilitiesResponse.getDescriptions()
                        .stream()
                        .filter(entry -> "en".equals(entry.getLanguage().getName()))
                        .filter(entry -> "platinum".equals(entry.getVersion().getName()))
                        .map(entry -> entry.getDescription())
                        .findFirst()
                        .orElse("No description available");

                return new AbilitiyDTO(name, description);
            }).toList();

        PokeApiPokemonEvolutionChainResponse evolutionResponse = client.getPokemonEvolutionChainById(evolutionChainId);

        List<EvolutionChainDTO> evolutionChainDTOList = buildEvolutionList(evolutionResponse);

        return mapper.toPokemonDetailDTO(response, specieResponse, abilitiyDTOList, evolutionChainDTOList);
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

                    long id = PokemonUtils.extractIdFromUrl(entry.getUrl());

                    PokeApiPokemonResponse response =
                            client.getPokemonById(id);

                    return mapper.toPokemonDTO(response);
                })
                .toList();
    }

    public static List<EvolutionChainDTO> buildEvolutionList(PokeApiPokemonEvolutionChainResponse evolutionChainResponse) {

        List<EvolutionChainDTO> evolutionChainDTOList = new ArrayList<>();
        List<EvolutionDTO> evolutionDTOList = new ArrayList<>();

        if (evolutionChainResponse.getChainLink() == null) return null;

        PokeApiPokemonEvolutionChainResponse.ChainLink chainLink = evolutionChainResponse.getChainLink();

        long pokemonEvolutionId =  PokemonUtils.extractIdFromUrl(chainLink.getSpecies().getUrl());

        EvolutionDTO firstEvolution = new EvolutionDTO(
                pokemonEvolutionId,
                chainLink.getSpecies().getName(),
                PokemonUtils.buildImageUrl(pokemonEvolutionId)
        );

        evolutionDTOList.add(firstEvolution);
        EvolutionChainDTO evolutionChainDTO = new EvolutionChainDTO();
        evolutionChainDTO.setEvolutionDTOList(evolutionDTOList);
        evolutionChainDTOList.add(evolutionChainDTO);

        return evolutionChainDTOList;
    }


}

