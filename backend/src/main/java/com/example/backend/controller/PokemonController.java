package com.example.backend.controller;

import com.example.backend.dto.PokemonDTO;
import com.example.backend.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<PokemonDTO>> getAllPokemons() {
        return ResponseEntity.ok(service.getAllPokemons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> getPokemon(@PathVariable long id) {
        return ResponseEntity.ok(service.getPokemon(id));
    }
}

