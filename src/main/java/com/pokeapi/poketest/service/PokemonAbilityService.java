package com.pokeapi.poketest.service;

import java.util.List;
import com.pokeapi.poketest.dto.PokemonAbilityDto;

public interface PokemonAbilityService {
    List<PokemonAbilityDto> findAll();
    PokemonAbilityDto findById(Integer id);
    PokemonAbilityDto save(PokemonAbilityDto pokemonAbilityDto);
    void delete(Integer id);
}