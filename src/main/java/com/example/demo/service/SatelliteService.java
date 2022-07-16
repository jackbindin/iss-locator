package com.example.demo.service;

import com.example.demo.model.SatelliteLocation;
import com.example.demo.repository.IssRepository;
import com.example.demo.webclient.IssWebClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SatelliteService implements SatelliteServiceInterface{
    @Autowired
    IssRepository issRepository;
    @Autowired
    IssWebClientInterface issWebClient;

    private final int TABLE_CLEANUP_DELAY = 5 * 60 * 1000;
    private final int ISS_ID = 25544;
    private final int MAX_TABLE_SIZE = 10;

    @Override
    @Scheduled(fixedDelay = TABLE_CLEANUP_DELAY)
    public void refreshStoredLocation() {
        SatelliteLocation satelliteLocation = issWebClient.satelliteById(ISS_ID).block();
        issRepository.save(satelliteLocation);
        while(issRepository.findAll().size()>MAX_TABLE_SIZE){
            issRepository.delete(issRepository.findAll().get(0));
        }
    }

    @Override
    public List<SatelliteLocation> getAllSatelliteLocations(){
        return issRepository.findAll();
    }
}
