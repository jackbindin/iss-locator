package com.example.isslocator.webclient;

import com.example.isslocator.model.SatelliteLocation;
import reactor.core.publisher.Mono;

public interface IssWebClientInterface {
    Mono<SatelliteLocation> satelliteById(int id);
}
