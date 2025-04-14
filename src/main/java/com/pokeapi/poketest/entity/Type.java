package com.pokeapi.poketest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="type")
public class Type {
	
	@Id
	@Column(name = "idtype", columnDefinition = "INTEGER")
	private Integer idType;
	
	@Column(name = "name", columnDefinition = "VARCHAR(100)", unique = true)
	private String name;

	// Default constructor
	public Type() {
	}

	// Parameterized constructor
	public Type(Integer idType, String name) {
		this.idType = idType;
		this.name = name;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
