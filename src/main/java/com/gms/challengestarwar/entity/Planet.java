package com.gms.challengestarwar.entity;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planets")
public class Planet {
	
	@Id
	private String id;
	@NotNull @NotEmpty
	private String name;
	@NotNull @NotEmpty
	private String climate;
	@NotNull @NotEmpty
	private String terrain;
	private int films;
	
	
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	
	public int getFilms() {
		return films;
	}
	public void setFilms(int films) {
		this.films = films;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public Planet(String nome, String clima, int aparicaoFilmes) {
		this.name = nome;
		this.climate = clima;
		
	}
	public Planet() {
		
	}
	

}
