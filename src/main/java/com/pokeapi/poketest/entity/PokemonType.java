package com.pokeapi.poketest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="pokemon_type", uniqueConstraints = { 
	@UniqueConstraint(columnNames = {"idPokenom", "idType"}) 
})
public class PokemonType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpokemontype", columnDefinition = "INTEGER")
	private Integer idPokemonType;
	
	@Column(name = "idpokenom", columnDefinition = "INTEGER")
	private Integer idPokenom;
	
	@Column(name = "idtype", columnDefinition = "INTEGER")
	private Integer idType;
	
	@Column(name = "slot", columnDefinition = "INTEGER")
	private Integer slot;

    public PokemonType(Integer idPokemonType, Integer idPokenom, Integer idType, Integer slot) {
        this.idPokemonType = idPokemonType;
        this.idPokenom = idPokenom;
        this.idType = idType;
        this.slot = slot;
    }

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
