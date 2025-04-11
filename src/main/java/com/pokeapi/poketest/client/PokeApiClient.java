package com.pokeapi.poketest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokeApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon?offset={offset}&limit={limit}";

    public ResponseEntity<String> getPokemonPage(int offset, int limit) {
        return restTemplate.getForEntity(BASE_URL, String.class, offset, limit);
    }

    public ResponseEntity<String> getPokemonDetail(String url) {
        return restTemplate.getForEntity(url, String.class);
    }
}

