package com.pokeapi.poketest.service;

import java.util.List;

import com.pokeapi.poketest.dto.AbilityDto;

public interface AbilityService {
    List<AbilityDto> findAll();
    AbilityDto findById(Integer id);
    AbilityDto save(AbilityDto abilityDto);
    void saveAbilitiesData(int limit, int offset);
    void delete(Integer id);
}