package com.example.isslocator.webclient;

import com.example.isslocator.model.SatelliteLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class IssWebClient implements IssWebClientInterface{
    @Autowired
    WebClient webClient;

    @Cacheable("satelliteById")
    public Mono<SatelliteLocation> satelliteById(int id) {
        return this.webClient.get().uri("/{id}",id)
                .retrieve().bodyToMono(SatelliteLocation.class);
    }
}
