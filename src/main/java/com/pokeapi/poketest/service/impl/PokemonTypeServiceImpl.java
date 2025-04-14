package com.pokeapi.poketest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.dao.PokemonTypeDao;
import com.pokeapi.poketest.dto.PokemonTypeDto;
import com.pokeapi.poketest.entity.PokemonType;
import com.pokeapi.poketest.service.PokemonTypeService;
import org.modelmapper.ModelMapper;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    @Autowired
    private PokemonTypeDao pokemonTypeDao;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PokemonTypeDto> findAll() {
        List<PokemonTypeDto> types = new ArrayList<>();
        pokemonTypeDao.findAll().forEach(type -> {
            PokemonTypeDto dto = modelMapper.map(type, PokemonTypeDto.class);
            types.add(dto);
        });
        return types;
    }

    @Override
    public PokemonTypeDto findById(Integer id) {
        Optional<PokemonType> type = pokemonTypeDao.findById(id);
        return type.map(value -> modelMapper.map(value, PokemonTypeDto.class)).orElse(null);
    }

    @Override
    public PokemonTypeDto save(PokemonTypeDto pokemonTypeDto) {
        PokemonType type = modelMapper.map(pokemonTypeDto, PokemonType.class);
        type = pokemonTypeDao.save(type);
        return modelMapper.map(type, PokemonTypeDto.class);
    }

    @Override
    public void delete(Integer id) {
        pokemonTypeDao.deleteById(id);
    }
}