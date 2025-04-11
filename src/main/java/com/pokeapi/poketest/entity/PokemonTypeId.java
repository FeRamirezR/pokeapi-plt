package com.pokeapi.poketest.entity;

import java.io.Serializable;
import java.util.Objects;

public class PokemonTypeId implements Serializable {
    private Integer pokemon;
    private Integer type;

    public PokemonTypeId() {}

    public PokemonTypeId(Integer pokemon, Integer type) {
        this.pokemon = pokemon;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokemonTypeId that)) return false;
        return Objects.equals(pokemon, that.pokemon) &&
               Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemon, type);
    }
}
