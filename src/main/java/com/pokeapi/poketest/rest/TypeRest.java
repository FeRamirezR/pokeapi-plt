package com.pokeapi.poketest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokeapi.poketest.dto.TypeDto;
import com.pokeapi.poketest.service.TypeService;

@RestController
@RequestMapping("/api/types")
public class TypeRest {

    @Autowired
    private TypeService typeService;

    @GetMapping
    public List<TypeDto> getAllTypes() {
        return typeService.findAll();
    }

    @GetMapping("/{id}")
    public TypeDto getTypeById(@PathVariable Integer id) {
        return typeService.findById(id);
    }

    @PostMapping
    public TypeDto createType(@RequestBody TypeDto typeDto) {
        return typeService.save(typeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Integer id) {
        typeService.delete(id);
    }
}