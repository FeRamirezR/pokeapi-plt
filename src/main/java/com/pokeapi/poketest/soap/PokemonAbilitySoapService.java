package com.pokeapi.poketest.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pokeapi.poketest.dto.PokemonAbilityDto;
import com.pokeapi.poketest.service.PokemonAbilityService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PokemonAbilitySoapService")
@Service
public class PokemonAbilitySoapService {

    @Autowired
    private PokemonAbilityService pokemonAbilityService;

    @WebMethod
    public List<PokemonAbilityDto> getAllPokemonAbilities() {
        return pokemonAbilityService.findAll();
    }

    @WebMethod
    public PokemonAbilityDto getPokemonAbilityById(Integer id) {
        return pokemonAbilityService.findById(id);
    }

    @WebMethod
    public PokemonAbilityDto createPokemonAbility(PokemonAbilityDto pokemonAbilityDto) {
        return pokemonAbilityService.save(pokemonAbilityDto);
    }

    @WebMethod
    public void deletePokemonAbility(Integer id) {
        pokemonAbilityService.delete(id);
    }
}