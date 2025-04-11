package com.pokeapi.poketest.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Table(name = "pokemon")
public class Pokemon {

    @Id
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    private Integer height;
    private Integer weight;

    @Column(name = "base_experience")
    private Integer baseExperience;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    // Relaciones (opcional si deseas mapearlas)
    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PokemonType> pokemonTypes;

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PokemonAbility> pokemonAbilities;

    // Constructores
    public Pokemon() {}

    public Pokemon(Integer id, String name, Integer height, Integer weight, Integer baseExperience,
                   LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.baseExperience = baseExperience;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    // Getters y Setters

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getHeight() { return height; }

    public void setHeight(Integer height) { this.height = height; }

    public Integer getWeight() { return weight; }

    public void setWeight(Integer weight) { this.weight = weight; }

    public Integer getBaseExperience() { return baseExperience; }

    public void setBaseExperience(Integer baseExperience) { this.baseExperience = baseExperience; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getCreatedBy() { return createdBy; }

    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getUpdatedBy() { return updatedBy; }

    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }

    public Set<PokemonType> getPokemonTypes() { return pokemonTypes; }

    public void setPokemonTypes(Set<PokemonType> pokemonTypes) { this.pokemonTypes = pokemonTypes; }

    public Set<PokemonAbility> getPokemonAbilities() { return pokemonAbilities; }
    // Removed duplicate methods
    public void setPokemonAbilities(Set<PokemonAbility> pokemonAbilities) {
        this.pokemonAbilities = pokemonAbilities;
    }
}
