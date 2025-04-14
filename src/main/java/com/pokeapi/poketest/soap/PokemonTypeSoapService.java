package com.pokeapi.poketest.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pokeapi.poketest.dto.PokemonTypeDto;
import com.pokeapi.poketest.service.PokemonTypeService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PokemonTypeSoapService")
@Service
public class PokemonTypeSoapService {

    @Autowired
    private PokemonTypeService pokemonTypeService;

    @WebMethod
    public List<PokemonTypeDto> getAllPokemonTypes() {
        return pokemonTypeService.findAll();
    }

    @WebMethod
    public PokemonTypeDto getPokemonTypeById(Integer id) {
        return pokemonTypeService.findById(id);
    }

    @WebMethod
    public PokemonTypeDto createPokemonType(PokemonTypeDto pokemonTypeDto) {
        return pokemonTypeService.save(pokemonTypeDto);
    }

    @WebMethod
    public void deletePokemonType(Integer id) {
        pokemonTypeService.delete(id);
    }
}