package com.pokeapi.poketest.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.dto.AbilityDto;
import com.pokeapi.poketest.service.AbilityService;

@WebService(serviceName = "AbilitySoapService")
@Service
public class AbilitySoapService {

    @Autowired
    private AbilityService abilityService;

    @WebMethod
    public List<AbilityDto> getAllAbilities() {
        return abilityService.findAll();
    }

    @WebMethod
    public AbilityDto getAbilityById(Integer id) {
        return abilityService.findById(id);
    }

    @WebMethod
    public AbilityDto createAbility(AbilityDto abilityDto) {
        return abilityService.save(abilityDto);
    }

    @WebMethod
    public void deleteAbility(Integer id) {
        abilityService.delete(id);
    }
}