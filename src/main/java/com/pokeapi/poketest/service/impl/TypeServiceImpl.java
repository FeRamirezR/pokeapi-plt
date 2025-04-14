package com.pokeapi.poketest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.client.PokemonRestClient;
import com.pokeapi.poketest.dao.TypeDao;
import com.pokeapi.poketest.dto.PokemonApiResultDto;
import com.pokeapi.poketest.dto.TypeDto;
import com.pokeapi.poketest.entity.Type;
import com.pokeapi.poketest.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    private final PokemonRestClient pokemonRestClient;

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public TypeServiceImpl(PokemonRestClient pokemonRestClient) {
        this.pokemonRestClient = pokemonRestClient;
    }

    @Override
    public List<TypeDto> findAll() {
        List<TypeDto> types = new ArrayList<>();
        typeDao.findAll().forEach(type -> {
            TypeDto dto = modelMapper.map(type, TypeDto.class);
            types.add(dto);
        });
        return types;
    }

    @Override
    public TypeDto findById(Integer id) {
        Optional<Type> type = typeDao.findById(id);
        return type.map(value -> modelMapper.map(value, TypeDto.class)).orElse(null);
    }

    @Override
    public TypeDto save(TypeDto typeDto) {
        Type type = modelMapper.map(typeDto, Type.class);
        type = typeDao.save(type);
        return modelMapper.map(type, TypeDto.class);
    }
    
    @Override
    public void saveTypesData(int limit, int offset) {
        List<PokemonApiResultDto> types = pokemonRestClient.getAllTypes(limit, offset).getResults();
    
        List<Type> typeEntities = types.stream().map(pokemon -> {
            Integer id = extractIdFromUrl(pokemon.getUrl());
            Type existingType = typeDao.findById(id).orElse(null);
            if (existingType == null) {
                return new Type(id, pokemon.getName());
            }
            return null; // Omite si ya existe
        }).filter(type -> type != null).collect(Collectors.toList());
    
        if (!typeEntities.isEmpty()) {
            typeDao.saveAll(typeEntities);
        }
    }

    private int extractIdFromUrl(String url) {
        String[] parts = url.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    @Override
    public void delete(Integer id) {
        typeDao.deleteById(id);
    }
}