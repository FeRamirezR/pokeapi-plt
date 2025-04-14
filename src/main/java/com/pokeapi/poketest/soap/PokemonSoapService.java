package com.pokeapi.poketest.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.dto.PokemonDto;
import com.pokeapi.poketest.service.PokemonService;

@WebService(serviceName = "PokemonSoapService")
@Service
public class PokemonSoapService {

    @Autowired
    private PokemonService pokemonService;

    @WebMethod
    public List<PokemonDto> getAllPokemons() {
        return pokemonService.findAll();
    }

    @WebMethod
    public PokemonDto getPokemonById(Integer id) {
        return pokemonService.findById(id);
    }

    @WebMethod
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        return pokemonService.save(pokemonDto);
    }

    @WebMethod
    public void deletePokemon(Integer id) {
        pokemonService.delete(id);
    }
}