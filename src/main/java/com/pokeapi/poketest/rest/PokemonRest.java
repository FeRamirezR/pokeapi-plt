package com.pokeapi.poketest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokeapi.poketest.dto.PokemonDto;
import com.pokeapi.poketest.service.PokemonService;

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
    public PokemonDto getPokemonById(@PathVariable Integer id) {
        return pokemonService.findById(id);
    }

    @PostMapping
    public PokemonDto createPokemon(@RequestBody PokemonDto pokemonDto) {
        return pokemonService.save(pokemonDto);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Integer id) {
        pokemonService.delete(id);
    }
}