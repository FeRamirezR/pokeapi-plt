package com.pokeapi.poketest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pokeapi.poketest.dto.PokemonAbilityDto;
import com.pokeapi.poketest.service.PokemonAbilityService;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon-abilities")
public class PokemonAbilityRest {

    @Autowired
    private PokemonAbilityService pokemonAbilityService;

    @GetMapping
    public List<PokemonAbilityDto> getAllPokemonAbilities() {
        return pokemonAbilityService.findAll();
    }

    @GetMapping("/{id}")
    public PokemonAbilityDto getPokemonAbilityById(@PathVariable Integer id) {
        return pokemonAbilityService.findById(id);
    }

    @PostMapping
    public PokemonAbilityDto createPokemonAbility(@RequestBody PokemonAbilityDto pokemonAbilityDto) {
        return pokemonAbilityService.save(pokemonAbilityDto);
    }

    @DeleteMapping("/{id}")
    public void deletePokemonAbility(@PathVariable Integer id) {
        pokemonAbilityService.delete(id);
    }
}