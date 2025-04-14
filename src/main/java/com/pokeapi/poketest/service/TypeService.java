package com.pokeapi.poketest.service;

import java.util.List;

import com.pokeapi.poketest.dto.TypeDto;

public interface TypeService {
    List<TypeDto> findAll();
    TypeDto findById(Integer id);
    TypeDto save(TypeDto typeDto);
    void saveTypesData(int limit, int offset);
    void delete(Integer id);
}