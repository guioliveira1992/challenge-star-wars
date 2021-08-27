package com.gms.challengestarwar.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gms.challengestarwar.entity.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String>{
	
	Optional<Planet> findByName(String name);

}
