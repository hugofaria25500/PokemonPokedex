package com.example.backend.controller;

import com.example.backend.dto.PokemonDTO;
import com.example.backend.dto.PokemonDetailDTO;
import com.example.backend.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService service;

    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<PokemonDTO>> getPokemons(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String sort
    ) {
        logger.info("getPokemons(offset:{}, searchTerm:{}, type:{}, region:{}, sort:{})", offset, searchTerm, type, region, sort);
        return ResponseEntity.ok(service.getPokemons(offset, searchTerm, type, region, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> getPokemon(@PathVariable long id) {
        logger.info("getPokemon(id:{})", id);
        return ResponseEntity.ok(service.getPokemon(id));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<PokemonDetailDTO> getPokemonDetails(@PathVariable long id) {
        logger.info("getPokemonPokemonDetails(id:{})", id);
        return ResponseEntity.ok(service.getPokemonDetails(id));
    }
}

