package com.pokeapi.poketest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.client.PokemonRestClient;
import com.pokeapi.poketest.dao.AbilityDao;
import com.pokeapi.poketest.dto.AbilityDto;
import com.pokeapi.poketest.dto.PokemonApiResultDto;
import com.pokeapi.poketest.entity.Ability;
import com.pokeapi.poketest.service.AbilityService;

@Service
public class AbilityServiceImpl implements AbilityService {

    @Autowired
    private AbilityDao abilityDao;

    private final PokemonRestClient pokemonRestClient;

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public AbilityServiceImpl(PokemonRestClient pokemonRestClient) {
        this.pokemonRestClient = pokemonRestClient;
    }

    @Override
    public List<AbilityDto> findAll() {
        List<AbilityDto> abilities = new ArrayList<>();
        abilityDao.findAll().forEach(ability -> {
            AbilityDto dto = modelMapper.map(ability, AbilityDto.class);
            abilities.add(dto);
        });
        return abilities;
    }

    @Override
    public AbilityDto findById(Integer id) {
        Optional<Ability> ability = abilityDao.findById(id);
        return ability.map(value -> modelMapper.map(value, AbilityDto.class)).orElse(null);
    }

    @Override
    public AbilityDto save(AbilityDto abilityDto) {
        Ability ability = modelMapper.map(abilityDto, Ability.class);
        ability = abilityDao.save(ability);
        return modelMapper.map(ability, AbilityDto.class);
    }

    @Override
    public void saveAbilitiesData(int limit, int offset) {
        List<PokemonApiResultDto> abilities = pokemonRestClient.getAllAbilities(limit, offset).getResults();

        List<Ability> abilityEntities = abilities.stream().map(pokemon -> {
            Integer id = extractIdFromUrl(pokemon.getUrl());
            Ability existingAbility = abilityDao.findById(id).orElse(null);
            if (existingAbility == null) {
                return new Ability(id, pokemon.getName());
            }
            return null; // Omite si ya existe
        }).filter(ability -> ability != null).collect(Collectors.toList());

        if (!abilityEntities.isEmpty()) {
            abilityDao.saveAll(abilityEntities);
        }
    }

    private int extractIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    @Override
    public void delete(Integer id) {
        abilityDao.deleteById(id);
    }
}