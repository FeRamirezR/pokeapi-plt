package com.pokeapi.poketest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.client.PokemonRestClient;
import com.pokeapi.poketest.dao.PokemonDao;
import com.pokeapi.poketest.dto.PokemonApiResultDto;
import com.pokeapi.poketest.dto.PokemonDto;
import com.pokeapi.poketest.entity.Pokemon;
import com.pokeapi.poketest.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonDao pokemonDao;

    private final PokemonRestClient pokemonRestClient;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PokemonDto> findAll() {
        List<PokemonDto> pokemons = new ArrayList<>();
        pokemonDao.findAll().forEach(pokemon -> {
            PokemonDto dto = modelMapper.map(pokemon, PokemonDto.class);
            pokemons.add(dto);
        });
        return pokemons;
    }

    @Override
    public PokemonDto findById(Integer id) {
        Optional<Pokemon> pokemon = pokemonDao.findById(id);
        return pokemon.map(value -> modelMapper.map(value, PokemonDto.class)).orElse(null);
    }

    @Override
    public PokemonDto save(PokemonDto pokemonDto) {
        Pokemon pokemon = modelMapper.map(pokemonDto, Pokemon.class);
        pokemon = pokemonDao.save(pokemon);
        return modelMapper.map(pokemon, PokemonDto.class);
    }

    public PokemonServiceImpl(PokemonRestClient pokemonRestClient, PokemonDao pokemonDao) {
        this.pokemonRestClient = pokemonRestClient;
        this.pokemonDao = pokemonDao;
    }

    @Override
    public void savePokemonData(int limit, int offset) {
        List<PokemonApiResultDto> pokemons = pokemonRestClient.getAllPokemons(limit, offset).getResults();

        List<Pokemon> pokemonEntities = pokemons.stream().map(pokemon -> {
            Integer id = extractIdFromUrl(pokemon.getUrl());
            Pokemon existingPokemon = pokemonDao.findById(id).orElse(null); // Usa Integer
            if (existingPokemon == null) {
                return new Pokemon(id, pokemon.getName(), null, null, null);
            }
            return null; // Omite si ya existe
        }).filter(pokemon -> pokemon != null).collect(Collectors.toList());

        if (!pokemonEntities.isEmpty()) {
            pokemonDao.saveAll(pokemonEntities);
        }
    }

    private int extractIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    @Override
    public void delete(Integer id) {
        pokemonDao.deleteById(id);
    }
}