package com.pokeapi.poketest.dao;

import org.springframework.data.repository.CrudRepository;

import com.pokeapi.poketest.entity.Pokemon;

public interface PokemonDao extends CrudRepository<Pokemon, Integer> {
}