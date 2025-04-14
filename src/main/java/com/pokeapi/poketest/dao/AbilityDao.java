package com.pokeapi.poketest.dao;

import org.springframework.data.repository.CrudRepository;

import com.pokeapi.poketest.entity.Ability;

public interface AbilityDao extends CrudRepository<Ability, Integer> {
}