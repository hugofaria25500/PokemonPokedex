package com.example.backend.controller;

import com.example.backend.dto.BasicPokemonDTO;
import com.example.backend.dto.PokemonDTO;
import com.example.backend.dto.PokemonDetailDTO;
import com.example.backend.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService service;

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
        return ResponseEntity.ok(service.getPokemons(offset, searchTerm, type, region, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> getPokemon(@PathVariable long id) {
        return ResponseEntity.ok(service.getPokemon(id));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<PokemonDetailDTO> getPokemonDetails(@PathVariable long id) {
        return ResponseEntity.ok(service.getPokemonDetails(id));
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<BasicPokemonDTO>> getFilteredPokemons(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String sort
    ) {
        return ResponseEntity.ok(service.getFilteredPokemons(offset, searchTerm, type, region, sort));
    }
}

