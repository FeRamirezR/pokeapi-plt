package com.pokeapi.poketest.dao;

import org.springframework.data.repository.CrudRepository;
import com.pokeapi.poketest.entity.PokemonAbility;

public interface PokemonAbilityDao extends CrudRepository<PokemonAbility, Integer> {
}