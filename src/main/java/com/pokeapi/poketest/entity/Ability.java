package com.pokeapi.poketest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ability")
public class Ability {
	
	@Id
    @Column(name = "idability", columnDefinition = "INTEGER")
	private Integer idAbility;
	
	@Column(name = "name", columnDefinition = "VARCHAR(100)", unique=true)
	private String name;

	public Ability() {
	}

	public Ability(Integer idAbility, String name) {
		this.idAbility = idAbility;
		this.name = name;
	}

	public Integer getId() {
		return idAbility;
	}

	public void setId(Integer idAbility) {
		this.idAbility = idAbility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
