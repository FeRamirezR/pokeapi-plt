package com.pokeapi.poketest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="type")
public class Type {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idType", columnDefinition = "INTEGER")
	private String idType;
	
	@Column(name = "name", columnDefinition = "VARCHAR(100)",unique=true)
	private String name;

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
