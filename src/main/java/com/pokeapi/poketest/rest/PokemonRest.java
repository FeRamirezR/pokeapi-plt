package com.pokeapi.poketest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pokeapi.poketest.dto.PokemonDto;
import com.pokeapi.poketest.service.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonRest {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<PokemonDto> getAllPokemons() {
        return pokemonService.findAll();
    }

    @GetMapping("/{id}")
    public PokemonDto getPokemonById(@PathVariable String id) {
        return pokemonService.findById(id);
    }

    @PostMapping
    public PokemonDto createPokemon(@RequestBody PokemonDto pokemonDto) {
        return pokemonService.save(pokemonDto);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable String id) {
        pokemonService.delete(id);
    }
}