package com.pokeapi.poketest.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PokemonAbilityId implements Serializable {

    private Long pokemonId;
    private Long abilityId;

    public PokemonAbilityId() {
    }

    public PokemonAbilityId(Long pokemonId, Long abilityId) {
        this.pokemonId = pokemonId;
        this.abilityId = abilityId;
    }

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Long getAbilityId() {
        return abilityId;
    }

    public void setAbilityId(Long abilityId) {
        this.abilityId = abilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokemonAbilityId)) return false;
        PokemonAbilityId that = (PokemonAbilityId) o;
        return Objects.equals(pokemonId, that.pokemonId) &&
               Objects.equals(abilityId, that.abilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonId, abilityId);
    }
}

