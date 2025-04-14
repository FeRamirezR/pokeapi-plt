package com.pokeapi.poketest.initializer;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.pokeapi.poketest.service.PokemonService;

@Component
public class PokemonDataInitializer {

    private final PokemonService pokemonService;

    public PokemonDataInitializer(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostConstruct
    public void initializePokemonData() {
        int limit = 20; // Número de registros a obtener por solicitud
        int offset = 0; // Punto de inicio
        pokemonService.savePokemonData(limit, offset);
        System.out.println("Pokemon data initialized successfully!");
    }
}