package com.example.backend.service;

import com.example.backend.client.PokemonClient;
import com.example.backend.client.response.*;
import com.example.backend.dto.*;
import com.example.backend.exception.PokemonNotFoundException;
import com.example.backend.mapper.PokemonMapper;
import com.example.backend.utils.PokemonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PokemonServiceImpl implements PokemonService {
    private final PokemonClient client;

    private final PokemonMapper mapper;

    private static final Logger logger = LoggerFactory.getLogger(PokemonServiceImpl.class);


    private int pokemonListSize = -1;

    public PokemonServiceImpl(PokemonClient client, PokemonMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    /**
     * Get pokemon dto by id
     * @param id
     * @return PokemonDTO
     */
    @Override
    @Cacheable("pokemon")
    public PokemonDTO getPokemon(long id) {
        PokeApiPokemonResponse response = client.getPokemonById(id);

        if (response == null) {
            throw new PokemonNotFoundException("Pokemon with id " + id + " not found");
        }

        PokemonDTO pokemonDTO = mapper.toPokemonDTO(response);
        logger.info("getPokemon Response: "+pokemonDTO.toString());
        return pokemonDTO;
    }

    /**
     * Get pokemon details dto by id
     * @param id
     * @return PokemonDetailDTO
     */
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

        PokemonDetailDTO pokemonDetailDTO = mapper.toPokemonDetailDTO(response, specieResponse, abilitiyDTOList, evolutionChainDTOList);
        logger.info("getPokemonDetails Response: "+pokemonDetailDTO.toString());

        return pokemonDetailDTO;
    }

    /**
     * Get filtered pokemons by params
     * @param offset
     * @param searchTerm
     * @param type
     * @param region
     * @param sort
     * @return List<PokemonDTO>
     */
    @Override
    @Cacheable("pokemons")
    public List<PokemonDTO> getPokemons(int offset, String searchTerm, String type, String region, String sort) {
        PokeApiPokemonListResponse listResponse = client.getPokemons(offset);

        if (listResponse == null) {
            throw new PokemonNotFoundException("Pokemons not found");
        }

        if((searchTerm == null || searchTerm.isEmpty()) && (type == null || type.isEmpty()) && (region == null || region.isEmpty()) && (sort == null || sort.isEmpty())) {

            List<PokemonDTO> firstPokemons = listResponse.getResults()
                    .parallelStream()
                    .map(entry -> {

                        long id = PokemonUtils.extractIdFromUrl(entry.getUrl());

                        PokeApiPokemonResponse response =
                                client.getPokemonById(id);

                        return mapper.toPokemonDTO(response);
                    })
                    .toList();

            if(!firstPokemons.isEmpty() && PokemonUtils.POKEMON_LIMIT - PokemonUtils.LIMIT == offset) {
                firstPokemons.get(firstPokemons.size()-1).setLast(true);
            }

            logger.info("getPokemons Response: " + firstPokemons);
            return firstPokemons;
        }

        List<PokemonDTO> filteredPokemons = getFilteredPokemons(offset, searchTerm, type, region, sort)
                .stream()
                .map(entry -> {
                    long id = PokemonUtils.extractIdFromUrl(entry.getUrl());
                    PokeApiPokemonResponse response =
                            client.getPokemonById(id);

                    return mapper.toPokemonDTO(response);
                }).toList();

        if(!filteredPokemons.isEmpty() && getPokemonListSize() < offset + PokemonUtils.LIMIT) {
            filteredPokemons.get(getPokemonListSize()-offset-1).setLast(true);
        }
        setPokemonListSize(-1);

        logger.info("getPokemons Response: " + filteredPokemons);
        return filteredPokemons;
    }

    /**
     * Get all basic pokemon dto
     * @return List<PokemonDTO>
     */
    @Cacheable("basicPokemons")
    @Override
    public List<BasicPokemonDTO> getBasicPokemons() {
        PokeApiBasicPokemonResponse apiBasicPokemonResponse = client.getBasicPokemonList();

        List<BasicPokemonDTO> basicPokemonDTOList = apiBasicPokemonResponse.getEntryList()
                .stream().map(entry -> new BasicPokemonDTO(entry.getName(), entry.getUrl()))
                .toList();
        logger.info("getBasicPokemons Response: " + basicPokemonDTOList);
        return basicPokemonDTOList;
    }

    /**
     * Get all basic pokemon dto by type
     * @param type
     * @return List<PokemonDTO>
     */
    @Override
    public List<BasicPokemonDTO> getBasicPokemonsByType(String type) {
        PokeApiPokemonByTypeResponse apiResponse = client.getBasicPokemonListByType(type);

        List<BasicPokemonDTO> basicPokemonDTOList = apiResponse.getEntryList()
                .stream().map(entry -> new BasicPokemonDTO(entry.getPokemon().getName(), entry.getPokemon().getUrl()))
                .toList();

        logger.info("getBasicPokemonsByType Response: " + basicPokemonDTOList);
        return basicPokemonDTOList;
    }

    /**
     * Get all basic pokemon dto by region
     * @param region
     * @return List<PokemonDTO>
     */
    @Override
    public List<BasicPokemonDTO> getBasicPokemonsByRegion(String region) {
        long id = PokemonUtils.mapRegionToGenerationId(region);
        PokeApiPokemonByRegionResponse apiResponse = client.getBasicPokemonListByRegion(id);

        List<BasicPokemonDTO> basicPokemonDTOList = apiResponse.getEntryList()
                .stream().map(entry -> new BasicPokemonDTO(entry.getName(), entry.getUrl()))
                .toList();

        logger.info("getBasicPokemonsByRegion Response: " + basicPokemonDTOList);
        return basicPokemonDTOList;
    }

    /**
     * Get filtered pokemons by params
     * @param offset
     * @param searchTerm
     * @param type
     * @param region
     * @param sort
     * @return List<PokemonDTO>
     */
    @Cacheable("filteredPokemons")
    @Override
    public List<BasicPokemonDTO> getFilteredPokemons(int offset, String searchTerm, String type, String region, String sort) {

        List<BasicPokemonDTO> allPokemonsList = getBasicPokemons();

        String term = searchTerm == null ? "" : searchTerm.toLowerCase();
        List<BasicPokemonDTO> typeList = type != null && !type.isEmpty() ? getBasicPokemonsByType(type) : new ArrayList<>();
        List<BasicPokemonDTO> regionList = region != null && !region.isEmpty() ? getBasicPokemonsByRegion(region) : new ArrayList<>();
        String newSort = sort != null && !sort.isEmpty()? sort : "id-asc";

        Set<String> typeNames = typeList.stream()
                .map(BasicPokemonDTO::getName)
                .collect(Collectors.toSet());

        Set<String> regionNames = regionList.stream()
                .map(BasicPokemonDTO::getName)
                .collect(Collectors.toSet());

        Stream<BasicPokemonDTO> stream = allPokemonsList.stream();

        if (!typeNames.isEmpty()) {
            stream = stream.filter(p -> typeNames.contains(p.getName()));
        }

        if (!regionNames.isEmpty()) {
            stream = stream.filter(p -> regionNames.contains(p.getName()));
        }

        if (searchTerm != null && !searchTerm.isBlank()) {
            stream = stream.filter(p -> p.getName().contains(term));
        }

        List<BasicPokemonDTO> finalList = stream
                .sorted(buildComparatorBasedOnSort(newSort))
                .toList();

        setPokemonListSize(!finalList.isEmpty() ? finalList.size() : -1);

        if(!finalList.isEmpty() && finalList.size() < offset + PokemonUtils.LIMIT) {
            finalList = finalList.subList(offset, finalList.size());
            logger.info("getFilteredPokemons Response: " + finalList);
            return finalList;
        }

        finalList = !finalList.isEmpty() ? finalList.subList(offset, offset+PokemonUtils.LIMIT) : new ArrayList<>();
        logger.info("getFilteredPokemons Response: " + finalList);
        return finalList;
    }

    /**
     * Get pokemon evolution list
     * Recursive method to get evolution pokemons list of children elements
     * @param chainLink
     * @param currentPath
     * @param evolutionChains
     */
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

    /**
     * Get current pokemon evolution dto and add it to a list in order to track pokemon evolution elements
     * Complementary method for buildEvolutionList()
     * @param chainLink
     * @return EvolutionDTO
     */
    private EvolutionDTO buildEvolutionPokemonDTOFromCurrentChainLink(PokeApiPokemonEvolutionChainResponse.ChainLink chainLink) {
        if(chainLink.getSpecies() == null) return null;

        long id = PokemonUtils.extractIdFromUrl(chainLink.getSpecies().getUrl());
        PokeApiPokemonEvolutionResponse evolutionResponse = client.getPokemonEvolutionById(id);
        return mapper.toPokemonEvolutionDTO(evolutionResponse);
    }

    public int getPokemonListSize() {
        return pokemonListSize;
    }

    public void setPokemonListSize(int pokemonListSize) {
        this.pokemonListSize = pokemonListSize;
    }

    /**
     * Create comparator to manipulate easily based on sort param
     * @param sort
     * @return Comparator<BasicPokemonDTO>
     */
    private Comparator<BasicPokemonDTO> buildComparatorBasedOnSort(String sort) {

        Comparator<BasicPokemonDTO> byId =
                Comparator.comparingLong(p -> PokemonUtils.extractIdFromUrl(p.getUrl()));

        Comparator<BasicPokemonDTO> byName =
                Comparator.comparing(BasicPokemonDTO::getName);

        return switch (sort) {
            case "id-desc" -> byId.reversed();
            case "name-asc" -> byName;
            case "name-desc" -> byName.reversed();
            default -> byId;
        };

    }
}

