package com.pokeapi.poketest.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pokeapi.poketest.dto.PokemonDto;
import com.pokeapi.poketest.service.PokemonService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

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
    public PokemonDto getPokemonById(String id) {
        return pokemonService.findById(id);
    }

    @WebMethod
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        return pokemonService.save(pokemonDto);
    }

    @WebMethod
    public void deletePokemon(String id) {
        pokemonService.delete(id);
    }
}