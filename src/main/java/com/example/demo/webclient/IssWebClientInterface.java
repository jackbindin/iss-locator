package com.example.demo.webclient;

import com.example.demo.model.SatelliteLocation;
import reactor.core.publisher.Mono;

public interface IssWebClientInterface {
    Mono<SatelliteLocation> satelliteById(int id);
}
