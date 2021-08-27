package com.gms.challengestarwar.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientSwapiConfig {
	
	@Value("${changellenge.starwars.baseurl}")
	private String baseUrl;
	
	
	public WebClient getWebClient(){
		return WebClient.builder()
				  .baseUrl(baseUrl)
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				  .build();
	}

	
}
