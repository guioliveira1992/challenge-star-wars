package com.gms.challengestarwar.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gms.challengestarwar.dto.PlanetDTO;
import com.gms.challengestarwar.entity.Planet;
import com.gms.challengestarwar.repository.PlanetRepository;
import com.gms.challengestarwar.service.PlanetService;


@RestController
@RequestMapping("/planets")
public class PlanetController {

	@Autowired
	private PlanetRepository planetRepository;

	@Autowired
	private PlanetService planetService;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<Planet> planets = new ArrayList<Planet>();
		planets = planetRepository.findAll();
		return ResponseEntity.ok(PlanetDTO.converter(planets));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PlanetDTO> criar(@RequestBody @Valid Planet planet, UriComponentsBuilder uri) {
		planet.setFilms(planetService.getApparitionFilms(planet.getName()));
		planetRepository.save(planet);
		URI uriPath = uri.path("/planets/{id}").buildAndExpand(planet.getId()).toUri();
		return ResponseEntity.created(uriPath).body(new PlanetDTO(planet));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PlanetDTO> updated(@PathVariable String id, @RequestBody @Valid Planet planet) {
		Optional<Planet> optional = planetRepository.findById(id);
		if (optional.isPresent()) {
			planetRepository.save(planet);
			return ResponseEntity.ok(new PlanetDTO(planet));
		}
		return ResponseEntity.notFound().build();

	}

	@GetMapping("/{id}")
	public ResponseEntity<PlanetDTO> read(@PathVariable String id) {
		Optional<Planet> optional = planetRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new PlanetDTO(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable String id) {
		Optional<Planet> optional = planetRepository.findById(id);
		if (optional.isPresent()) {
			planetRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/search")
	public ResponseEntity<PlanetDTO> search(String name) {
		Optional<Planet> optional = planetRepository.findByName(name);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new PlanetDTO(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
