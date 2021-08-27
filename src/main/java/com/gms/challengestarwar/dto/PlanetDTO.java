package com.gms.challengestarwar.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gms.challengestarwar.entity.Planet;


public class PlanetDTO {

	private String id;
	private String name;
	private String climate;
	private String terrain;
	private int films;
	
	

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

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public PlanetDTO(Planet planet) {
		this.id = planet.getId();
		this.name = planet.getName();
		this.climate = planet.getClimate();
		this.films = planet.getFilms();
		this.terrain = planet.getTerrain();
	}
	
	public static List<PlanetDTO> converter(List<Planet> planets) {
		// TODO Auto-generated method stub
		return planets.stream().map(PlanetDTO::new).collect(Collectors.toList()); 
	}


}
