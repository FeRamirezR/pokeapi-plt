package com.pokeapi.poketest.service;

import java.util.List;
import com.pokeapi.poketest.dto.PokemonTypeDto;

public interface PokemonTypeService {
    List<PokemonTypeDto> findAll();
    PokemonTypeDto findById(Integer id);
    PokemonTypeDto save(PokemonTypeDto pokemonTypeDto);
    void delete(Integer id);
}