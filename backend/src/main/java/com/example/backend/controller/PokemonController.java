package com.example.backend.controller;

import com.example.backend.dto.PokemonDTO;
import com.example.backend.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public PokemonDTO getPokemon(@PathVariable long id) {
        return service.getPokemon(id);
    }
}

