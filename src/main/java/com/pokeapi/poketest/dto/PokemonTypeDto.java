package com.pokeapi.poketest.dto;

public class PokemonTypeDto {
    private Integer idPokemonType;
    private Integer idPokenom;
    private Integer idType;
    private Integer slot;

    public Integer getIdPokemonType() {
        return idPokemonType;
    }

    public void setIdPokemonType(Integer idPokemonType) {
        this.idPokemonType = idPokemonType;
    }

    public Integer getIdPokenom() {
        return idPokenom;
    }

    public void setIdPokenom(Integer idPokenom) {
        this.idPokenom = idPokenom;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
}