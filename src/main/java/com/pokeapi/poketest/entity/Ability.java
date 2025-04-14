package com.pokeapi.poketest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ability")
public class Ability {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAbility", columnDefinition = "INTEGER")
	private String idAbility;
	
	@Column(name = "name", columnDefinition = "VARCHAR(100)", unique=true)
	private String name;

	public String getId() {
		return idAbility;
	}

	public void setId(String idAbility) {
		this.idAbility = idAbility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
