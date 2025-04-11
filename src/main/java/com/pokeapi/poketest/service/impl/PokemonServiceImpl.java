package com.pokeapi.poketest.service.impl;

import com.pokeapi.poketest.dto.PokemonApiResponse;
import com.pokeapi.poketest.dto.PokemonDTO;
import com.pokeapi.poketest.service.PokemonService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final RestTemplate restTemplate;

    public PokemonServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PokemonDTO> getPokemons(int offset, int limit) {
        String url = String.format("https://pokeapi.co/api/v2/pokemon?offset=%d&limit=%d", offset, limit);
        PokemonApiResponse response = restTemplate.getForObject(url, PokemonApiResponse.class);

        if (response != null && response.getResults() != null) {
            return response.getResults().stream()
                    .map(p -> new PokemonDTO(p.getName(), p.getUrl()))
                    .collect(Collectors.toList());
        }
        return List.of();
    }
}

