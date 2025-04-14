package com.pokeapi.poketest.dto;

public class PokemonAbilityDto {
    private Integer idPokemonAbility;
    private Integer idPokenom;
    private Integer idAbility;
    private Integer slot;
    private Boolean isHidden;

    public Integer getIdPokemonAbility() {
        return idPokemonAbility;
    }

    public void setIdPokemonAbility(Integer idPokemonAbility) {
        this.idPokemonAbility = idPokemonAbility;
    }

    public Integer getIdPokenom() {
        return idPokenom;
    }

    public void setIdPokenom(Integer idPokenom) {
        this.idPokenom = idPokenom;
    }

    public Integer getIdAbility() {
        return idAbility;
    }

    public void setIdAbility(Integer idAbility) {
        this.idAbility = idAbility;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }
}