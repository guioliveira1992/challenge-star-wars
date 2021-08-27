package com.gms.challengestarwar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.gms.challengestarwar.modelRequest.PlanetResponse;

import reactor.core.publisher.Mono;

@Service
public class PlanetService {
	
	@Autowired
	private WebClientSwapiConfig webClientSwapiConfig;
	
	@Value("${changellenge.starwars.search.planets}")
	private String searchPlanets; 
	
	
	public int getApparitionFilms(String name) {
		Mono<PlanetResponse> planetMono = webClientSwapiConfig.getWebClient().method(HttpMethod.GET).uri(searchPlanets, name)
				.retrieve().bodyToMono(PlanetResponse.class);
		PlanetResponse planetResponse = planetMono.block();
		return planetResponse.getResults().get(0).getFilms().size();
	}

}
