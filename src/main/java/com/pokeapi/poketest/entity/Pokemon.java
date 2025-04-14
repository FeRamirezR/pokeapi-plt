package com.pokeapi.poketest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemon")
public class Pokemon {
	
	@Id
    @Column(name = "idpokemon", columnDefinition = "INTEGER")
	private Integer idPokemon;
	
	@Column(name = "name", columnDefinition = "VARCHAR(100)")
	private String name;

	@Column(name = "height", columnDefinition = "INTEGER")
	private Integer height;

	@Column(name = "weight", columnDefinition = "INTEGER")
	private Integer weight;
	
	@Column(name = "baseExperience", columnDefinition = "INTEGER")
	private Integer baseExperience;

	public Pokemon() {
    }

    public Pokemon(Integer idPokemon, String name,Integer baseExperience, Integer height, Integer weight) {
        this.idPokemon = idPokemon;
        this.name = name;
		this.baseExperience = baseExperience;
        this.height = height;
        this.weight = weight;
    }

	public Integer getId() {
		return idPokemon;
	}

	public void setId(Integer idPokemon) {
		this.idPokemon = idPokemon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getBase_experience() {
		return baseExperience;
	}

	public void setBaseExperience(Integer baseExperience) {
		this.baseExperience = baseExperience;
	}

}
