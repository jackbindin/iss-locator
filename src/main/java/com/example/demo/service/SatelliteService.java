package com.example.demo.service;

import com.example.demo.model.SatelliteLocation;
import com.example.demo.repository.IssRepository;
import com.example.demo.webclient.IssWebClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SatelliteService implements SatelliteServiceInterface{
    @Autowired
    IssRepository issRepository;
    @Autowired
    IssWebClientInterface issWebClient;

    @Override
    public SatelliteLocation getSatelliteById(int id) {
        SatelliteLocation satelliteLocation = issWebClient.satelliteById(id).block();
        issRepository.save(satelliteLocation);
        return satelliteLocation;
    }

    @Override
    public List<SatelliteLocation> getAllSatelliteLocations(){
        return issRepository.findAll();
    }
}
