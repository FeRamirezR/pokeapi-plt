package com.pokeapi.poketest.service;

import java.util.List;
import com.pokeapi.poketest.dto.AbilityDto;

public interface AbilityService {
    List<AbilityDto> findAll();
    AbilityDto findById(String id);
    AbilityDto save(AbilityDto abilityDto);
    void delete(String id);
}