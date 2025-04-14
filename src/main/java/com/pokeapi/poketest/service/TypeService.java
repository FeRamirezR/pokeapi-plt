package com.pokeapi.poketest.service;

import java.util.List;
import com.pokeapi.poketest.dto.TypeDto;

public interface TypeService {
    List<TypeDto> findAll();
    TypeDto findById(String id);
    TypeDto save(TypeDto typeDto);
    void delete(String id);
}