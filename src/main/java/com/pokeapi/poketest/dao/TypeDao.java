package com.pokeapi.poketest.dao;

import org.springframework.data.repository.CrudRepository;

import com.pokeapi.poketest.entity.Type;

public interface TypeDao extends CrudRepository<Type, Integer> {
}