package com.pokeapi.poketest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="pokemon_ability", uniqueConstraints = { 
	@UniqueConstraint(columnNames = {"idPokenom", "idAbility"}) 
})
public class PokemonAbility {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpokemonability", columnDefinition = "INTEGER")
	private Integer idPokemonAbility;
	
	@Column(name = "idpokenom", columnDefinition = "INTEGER")
	private Integer idPokenom;
	
	@Column(name = "idability", columnDefinition = "INTEGER")
	private Integer idAbility;
	
	@Column(name = "slot", columnDefinition = "INTEGER")
	private Integer slot;
	
	@Column(name = "ishidden", columnDefinition = "BOOLEAN")
	private Boolean isHidden;

    public PokemonAbility(Integer idAbility, Integer idPokemonAbility, Integer idPokenom, Boolean isHidden, Integer slot) {
        this.idAbility = idAbility;
        this.idPokemonAbility = idPokemonAbility;
        this.idPokenom = idPokenom;
        this.isHidden = isHidden;
        this.slot = slot;
    }

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
