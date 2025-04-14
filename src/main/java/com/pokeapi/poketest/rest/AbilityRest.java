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

import com.pokeapi.poketest.dto.AbilityDto;
import com.pokeapi.poketest.service.AbilityService;

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
    public AbilityDto getAbilityById(@PathVariable Integer id) {
        return abilityService.findById(id);
    }

    @PostMapping
    public AbilityDto createAbility(@RequestBody AbilityDto abilityDto) {
        return abilityService.save(abilityDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAbility(@PathVariable Integer id) {
        abilityService.delete(id);
    }
}