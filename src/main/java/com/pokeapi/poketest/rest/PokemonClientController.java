package com.pokeapi.poketest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pokeapi.poketest.client.PokemonRestClient;
import com.pokeapi.poketest.dto.PokemonApiResponseDto;

@RestController
@RequestMapping("/api/pokemon-client")
public class PokemonClientController {

    @Autowired
    private PokemonRestClient pokemonRestClient;

    @GetMapping("/pokemons")
    public PokemonApiResponseDto getAllPokemons(@RequestParam(defaultValue = "20") int limit, @RequestParam(defaultValue = "0") int offset) {
        return pokemonRestClient.getAllPokemons(limit, offset);
    }
}