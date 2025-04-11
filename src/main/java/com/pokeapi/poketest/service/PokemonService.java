package com.pokeapi.poketest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pokeapi.poketest.dto.PokemonDTO;

@Service
public class PokemonService {

    private final RestTemplate restTemplate;

    public PokemonService() {
        this.restTemplate = new RestTemplate();
    }

    public String getPokemonList() {
        return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon", String.class);
    }

    public List<PokemonDTO> getPokemons(int offset, int limit) {
        // Implement logic to fetch and return a list of PokemonDTO
        return null;
    }
}

