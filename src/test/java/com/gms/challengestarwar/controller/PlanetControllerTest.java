package com.gms.challengestarwar.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.gms.challengestarwar.entity.Planet;
import com.gms.challengestarwar.repository.PlanetRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PlanetControllerTest {
	
	@Autowired
	private MockMvc mocMvc;
	
	@Autowired
	private PlanetRepository repository;

	@Test
	void testarCadastroPlanet() throws Exception {
		URI uri = new URI("/planets");
		String json = "{\"name\": \"Corellia\",\"climate\": \"temperate\",\"terrain\": \"plains, urban, hills, forests\"}";
		 mocMvc.perform(MockMvcRequestBuilders
				.post(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(201));
		
	}
	
	@Test
	void testarAtualizacaoPlanet() throws Exception {
		List<Planet> planets = repository.findAll();
		assertTrue(planets.size() > 0);
		URI uri = new URI("/planets/"+planets.get(0).getId());
		String json = "{\"id\":\""+planets.get(0).getId()+"\","
				+ "\"name\": \""+planets.get(0).getName()+"\","
				+ "\"climate\": \""+planets.get(0).getClimate()+"\","
				+ "\"terrain\": \""+planets.get(0).getTerrain()+"\"}";
		 mocMvc.perform(MockMvcRequestBuilders
				.put(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
		
	}
	
	@Test
	void testarListaPlanetCadastrado() throws Exception {
		URI uri = new URI("/planets/");
		String json = "{}";
		mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void testarBuscarPlanetPeloNome() throws Exception {
		List<Planet> planets = repository.findAll();
		assertTrue(planets.size() > 0);
		URI uri = new URI("/planets/search?name="+planets.get(0).getName());
		String json = "{}";
		mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void testarConsultaPlanet() throws Exception {
		List<Planet> planets = repository.findAll();
		assertTrue(planets.size() > 0);
		URI uri = new URI("/planets/"+planets.get(0).getId());
		String json = "{}";
		mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void testarExclusaoPlanet() throws Exception {
		List<Planet> planets = repository.findAll();
		assertTrue(planets.size() > 0);
		URI uri = new URI("/planets/"+planets.get(0).getId());
		String json = "{}";
		mocMvc.perform(MockMvcRequestBuilders
				.delete(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	

}
