package com.pokeapi.poketest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.dao.TypeDao;
import com.pokeapi.poketest.dto.TypeDto;
import com.pokeapi.poketest.entity.Type;
import com.pokeapi.poketest.service.TypeService;
import org.modelmapper.ModelMapper;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    private final ModelMapper modelMapper = new ModelMapper();

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
    public TypeDto findById(String id) {
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
    public void delete(String id) {
        typeDao.deleteById(id);
    }
}