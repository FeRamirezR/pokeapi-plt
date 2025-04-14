package com.pokeapi.poketest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pokeapi.poketest.dto.TypeDto;
import com.pokeapi.poketest.service.TypeService;

import java.util.List;

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
    public TypeDto getTypeById(@PathVariable String id) {
        return typeService.findById(id);
    }

    @PostMapping
    public TypeDto createType(@RequestBody TypeDto typeDto) {
        return typeService.save(typeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable String id) {
        typeService.delete(id);
    }
}