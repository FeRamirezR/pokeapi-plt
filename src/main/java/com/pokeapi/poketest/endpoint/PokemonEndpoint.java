package com.pokeapi.poketest.endpoint;

import com.pokeapi.poketest.soap.GetPokemonsRequest;
import com.pokeapi.poketest.soap.GetPokemonsResponse;
import com.pokeapi.poketest.soap.Pokemon;
import com.pokeapi.poketest.service.PokemonService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://pokeapi.com/poketest/soap";

    private final PokemonService pokemonService;

    public PokemonEndpoint(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonsRequest")
    @ResponsePayload
    public GetPokemonsResponse getPokemons(@RequestPayload GetPokemonsRequest request) {
        List<Pokemon> pokemonList = pokemonService.getPokemons();

        GetPokemonsResponse response = new GetPokemonsResponse();
        response.getPokemons().addAll(pokemonList);

        return response;
    }
}
