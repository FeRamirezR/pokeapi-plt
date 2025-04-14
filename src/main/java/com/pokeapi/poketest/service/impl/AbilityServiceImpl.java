package com.pokeapi.poketest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.dao.AbilityDao;
import com.pokeapi.poketest.dto.AbilityDto;
import com.pokeapi.poketest.entity.Ability;
import com.pokeapi.poketest.service.AbilityService;
import org.modelmapper.ModelMapper;

@Service
public class AbilityServiceImpl implements AbilityService {

    @Autowired
    private AbilityDao abilityDao;

    private final ModelMapper modelMapper = new ModelMapper();

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
    public AbilityDto findById(String id) {
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
    public void delete(String id) {
        abilityDao.deleteById(id);
    }
}