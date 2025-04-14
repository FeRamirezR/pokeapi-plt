package com.pokeapi.poketest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pokeapi.poketest.dto.PokemonTypeDto;
import com.pokeapi.poketest.service.PokemonTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon-types")
public class PokemonTypeRest {

    @Autowired
    private PokemonTypeService pokemonTypeService;

    @GetMapping
    public List<PokemonTypeDto> getAllPokemonTypes() {
        return pokemonTypeService.findAll();
    }

    @GetMapping("/{id}")
    public PokemonTypeDto getPokemonTypeById(@PathVariable Integer id) {
        return pokemonTypeService.findById(id);
    }

    @PostMapping
    public PokemonTypeDto createPokemonType(@RequestBody PokemonTypeDto pokemonTypeDto) {
        return pokemonTypeService.save(pokemonTypeDto);
    }

    @DeleteMapping("/{id}")
    public void deletePokemonType(@PathVariable Integer id) {
        pokemonTypeService.delete(id);
    }
}