package com.pokeapi.poketest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pokeapi.poketest.dto.AbilityDto;
import com.pokeapi.poketest.service.AbilityService;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
public class AbilityRest {

    @Autowired
    private AbilityService abilityService;

    @GetMapping
    public List<AbilityDto> getAllAbilities() {
        return abilityService.findAll();
    }

    @GetMapping("/{id}")
    public AbilityDto getAbilityById(@PathVariable String id) {
        return abilityService.findById(id);
    }

    @PostMapping
    public AbilityDto createAbility(@RequestBody AbilityDto abilityDto) {
        return abilityService.save(abilityDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAbility(@PathVariable String id) {
        abilityService.delete(id);
    }
}