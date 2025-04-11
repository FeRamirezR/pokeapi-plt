package com.pokeapi.poketest.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
@Table(name = "pokemon_ability")
public class PokemonAbility {

    @EmbeddedId
    private PokemonAbilityId id = new PokemonAbilityId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pokemonId")
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("abilityId")
    @JoinColumn(name = "ability_id", nullable = false)
    private Ability ability;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "created_by", nullable = false)
    private String createdBy = "system";

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "updated_by", nullable = false)
    private String updatedBy = "system";

    public PokemonAbility() {
        // Default constructor
    }

    public PokemonAbility(Pokemon pokemon, Ability ability) {
        this.pokemon = pokemon;
        this.ability = ability;
        this.id = new PokemonAbilityId(pokemon.getId().longValue(), ability.getId().longValue());
    }
    public PokemonAbilityId getId() {
        return id;
    }

    public void setId(PokemonAbilityId id) {
        this.id = id;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

