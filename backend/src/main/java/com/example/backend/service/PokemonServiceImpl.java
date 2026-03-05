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
    public List<PokemonDTO> getPokemons(int offset, String searchTerm, String type, String region, String sort) {
        PokeApiPokemonListResponse listResponse = client.getPokemons(offset);

        if (listResponse == null) {
            throw new PokemonNotFoundException("Pokemons not found");
        }

        if((searchTerm == null || searchTerm.isEmpty()) && (type == null || type.isEmpty()) && (region == null || region.isEmpty()) && (sort == null || sort.isEmpty())) {
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

        return getFilteredPokemons(offset, searchTerm, type, region, sort)
                .stream()
                .map(entry -> {
                    long id = PokemonUtils.extractIdFromUrl(entry.getUrl());
                    PokeApiPokemonResponse response =
                            client.getPokemonById(id);

                    return mapper.toPokemonDTO(response);
                }).toList();
    }

    @Override
    public List<BasicPokemonDTO> getPokemonsByType(String type) {
        PokeApiPokemonByTypeResponse apiResponse = client.getBasicPokemonListByType(type);

        return apiResponse.getEntryList()
                .stream().map(entry -> new BasicPokemonDTO(entry.getPokemon().getName(), entry.getPokemon().getUrl()))
                .toList();
    }

    @Override
    public List<BasicPokemonDTO> getBasicPokemonsByRegion(String region) {
        long id = PokemonUtils.mapRegionToGenerationId(region);
        PokeApiPokemonByRegionResponse apiResponse = client.getBasicPokemonListByRegion(id);

        return apiResponse.getEntryList()
                .stream().map(entry -> new BasicPokemonDTO(entry.getPokemon().getName(), entry.getPokemon().getUrl()))
                .toList();
    }

    @Override
    public List<BasicPokemonDTO> getBasicPokemons() {
        PokeApiBasicPokemonsResponse apiResponse = client.getBasicPokemonList();

        return apiResponse.getEntryList()
                .stream().map(entry -> new BasicPokemonDTO(entry.getPokemon().getName(), entry.getPokemon().getUrl()))
                .toList();
    }

    @Cacheable("filteredPokemons")
    @Override
    public List<BasicPokemonDTO> getFilteredPokemons(int offset, String searchTerm, String type, String region, String sort) {
        List<BasicPokemonDTO> totalList = !type.isEmpty() ? getPokemonsByType(type) : null;
        return totalList != null ? totalList.subList(offset, offset+50) : null;
    }

    /*AUXILIARY METHODS*/
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

