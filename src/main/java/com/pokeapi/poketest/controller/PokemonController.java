package com.pokeapi.poketest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokeapi.poketest.dto.PokemonDTO;
import com.pokeapi.poketest.service.PokemonService;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<PokemonDTO> getPokemons(
        @RequestParam(defaultValue = "0") int offset,
        @RequestParam(defaultValue = "10") int limit) {
        return pokemonService.getPokemons(offset, limit);
    }
}


