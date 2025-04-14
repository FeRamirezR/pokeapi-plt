package com.pokeapi.poketest.initializer;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.pokeapi.poketest.service.AbilityService;

@Component
public class AbilityDataInitializer {

    private final AbilityService abilityService;

    public AbilityDataInitializer(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @PostConstruct
    public void initializeAbilityData() {
        int limit = 20; // Número de registros a obtener por solicitud
        int offset = 0; // Punto de inicio
        abilityService.saveAbilitiesData(limit, offset);
        System.out.println("Ability data initialized successfully!");
    }
}