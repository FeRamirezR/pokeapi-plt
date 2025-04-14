package com.pokeapi.poketest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.dao.PokemonAbilityDao;
import com.pokeapi.poketest.dto.PokemonAbilityDto;
import com.pokeapi.poketest.entity.PokemonAbility;
import com.pokeapi.poketest.service.PokemonAbilityService;
import org.modelmapper.ModelMapper;

@Service
public class PokemonAbilityServiceImpl implements PokemonAbilityService {

    @Autowired
    private PokemonAbilityDao pokemonAbilityDao;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PokemonAbilityDto> findAll() {
        List<PokemonAbilityDto> abilities = new ArrayList<>();
        pokemonAbilityDao.findAll().forEach(ability -> {
            PokemonAbilityDto dto = modelMapper.map(ability, PokemonAbilityDto.class);
            abilities.add(dto);
        });
        return abilities;
    }

    @Override
    public PokemonAbilityDto findById(Integer id) {
        Optional<PokemonAbility> ability = pokemonAbilityDao.findById(id);
        return ability.map(value -> modelMapper.map(value, PokemonAbilityDto.class)).orElse(null);
    }

    @Override
    public PokemonAbilityDto save(PokemonAbilityDto pokemonAbilityDto) {
        PokemonAbility ability = modelMapper.map(pokemonAbilityDto, PokemonAbility.class);
        ability = pokemonAbilityDao.save(ability);
        return modelMapper.map(ability, PokemonAbilityDto.class);
    }

    @Override
    public void delete(Integer id) {
        pokemonAbilityDao.deleteById(id);
    }
}