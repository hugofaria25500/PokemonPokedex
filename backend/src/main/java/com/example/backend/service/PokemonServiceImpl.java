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
public class PokemonServiceImpl implements PokemonService{
    private final PokemonClient client;

    private final PokemonMapper mapper;

    public PokemonServiceImpl(PokemonClient client, PokemonMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    @Cacheable("pokemon")
    public PokemonDTO getPokemon(long id) {
        PokeApiPokemonResponse response = client.getPokemonById(id);

        if (response == null) {
            throw new PokemonNotFoundException("Pokemon with id " + id + " not found");
        }

        return mapper.toPokemonDTO(response);
    }

    @Override
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

                String name = PokemonUtils.capitalizeText(abilitiesResponse.getName());

                String description = abilitiesResponse.getDescriptions()
                        .stream()
                        .filter(entry -> "en".equals(entry.getLanguage().getName()))
                        .filter(entry -> "platinum".equals(entry.getVersion().getName()))
                        .map(entry -> entry.getDescription())
                        .findFirst()
                        .orElse("No description available");

                description = PokemonUtils.cleanFlavorText(description);

                return new AbilitiyDTO(name, description);
            }).toList();

        PokeApiPokemonEvolutionChainResponse evolutionResponse = client.getPokemonEvolutionChainById(evolutionChainId);
        List<EvolutionChainDTO> evolutionChainDTOList = new ArrayList<>();

        buildEvolutionList(evolutionResponse.getChainLink(),new ArrayList<>(),evolutionChainDTOList);

        return mapper.toPokemonDetailDTO(response, specieResponse, abilitiyDTOList, evolutionChainDTOList);
    }

    @Override
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

    public void buildEvolutionList (PokeApiPokemonEvolutionChainResponse.ChainLink chainLink, List<EvolutionDTO> currentPath, List<EvolutionChainDTO> evolutionChains) {

        if (chainLink == null) return;

        currentPath.add(buildEvolutionPokemonDTOFromCurrentChainLink(chainLink));

        if (chainLink.getEvolvesTo() == null || chainLink.getEvolvesTo().isEmpty()) {

            EvolutionChainDTO chain = new EvolutionChainDTO();
            chain.setEvolutionList(new ArrayList<>(currentPath));
            evolutionChains.add(chain);
            return;
        }

        for (PokeApiPokemonEvolutionChainResponse.ChainLink next : chainLink.getEvolvesTo()) {
            buildEvolutionList(next, new ArrayList<>(currentPath), evolutionChains);
        }
    }

    private EvolutionDTO buildEvolutionPokemonDTOFromCurrentChainLink(PokeApiPokemonEvolutionChainResponse.ChainLink chainLink) {
        if(chainLink.getSpecies() == null) return null;

        long id = PokemonUtils.extractIdFromUrl(chainLink.getSpecies().getUrl());
        PokeApiPokemonEvolutionResponse evolutionResponse = client.getPokemonEvolutionById(id);
        return mapper.toPokemonEvolutionDTO(evolutionResponse);
    }
}

