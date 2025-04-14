package com.pokeapi.poketest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemon")
public class Pokemon {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPokemon", columnDefinition = "INTEGER")
	private Integer idPokemon;
	
	@Column(name = "name", columnDefinition = "VARCHAR(100)")
	private String name;

	@Column(name = "height", columnDefinition = "INTEGER")
	private String height;

	@Column(name = "weight", columnDefinition = "INTEGER")
	private String weight;
	
	@Column(name = "baseExperience", columnDefinition = "INTEGER")
	private String baseExperience;

    public Pokemon(String baseExperience, String height, Integer idPokemon, String name, String weight) {
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
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBase_experience() {
		return baseExperience;
	}

	public void setBaseExperience(String baseExperience) {
		this.baseExperience = baseExperience;
	}

}
