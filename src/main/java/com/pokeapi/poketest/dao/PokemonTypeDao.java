package com.pokeapi.poketest.dao;

import org.springframework.data.repository.CrudRepository;
import com.pokeapi.poketest.entity.PokemonType;

public interface PokemonTypeDao extends CrudRepository<PokemonType, Integer> {
}