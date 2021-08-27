package com.gms.challengestarwar.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gms.challengestarwar.entity.Planet;

@ExtendWith(SpringExtension.class)
@DataMongoTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class PlanetRepositoryTest {

	@Autowired
	private PlanetRepository repository;
	
	@Test
	void verificarSeExistePlanetaCadastradoPeloNome() {
		List<Planet> planets = repository.findAll();
		assertTrue(planets.size() > 0);
		Optional<Planet> planet = repository.findByName(planets.get(0).getName());
		assertNotNull(planet.get());
		assertEquals(planets.get(0).getName(), planet.get().getName());
	}

}
