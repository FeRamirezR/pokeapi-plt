package com.pokeapi.poketest.service;

import java.util.List;

import com.pokeapi.poketest.dto.PokemonDto;

public interface PokemonService {
    List<PokemonDto> findAll();
    PokemonDto findById(Integer id);
    PokemonDto save(PokemonDto pokemonDto);
    void savePokemonData(int limit, int offset);
    void delete(Integer id);
}