package com.pokeapi.poketest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pokeapi.poketest.dto.PokemonApiResponseDto;

@Component
public class PokemonRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public PokemonApiResponseDto getAllPokemons(int limit, int offset) {
        String url = "https://pokeapi.co/api/v2/pokemon/?limit=" + limit + "&offset=" + offset;
        return restTemplate.getForObject(url, PokemonApiResponseDto.class);
    }

    public PokemonApiResponseDto getAllAbilities(int limit, int offset) {
        String url = "https://pokeapi.co/api/v2/ability/?limit=" + limit + "&offset=" + offset;
        return restTemplate.getForObject(url, PokemonApiResponseDto.class);
    }
    public PokemonApiResponseDto getAllTypes(int limit, int offset) {
        String url = "https://pokeapi.co/api/v2/type/?limit=" + limit + "&offset=" + offset;
        return restTemplate.getForObject(url, PokemonApiResponseDto.class);
    }
}