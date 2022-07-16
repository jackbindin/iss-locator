package com.example.isslocator.service;

import com.example.isslocator.model.SatelliteLocation;
import com.example.isslocator.repository.IssRepository;
import com.example.isslocator.webclient.IssWebClientInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Log4j2
public class SatelliteService implements SatelliteServiceInterface{
    private final int TABLE_CLEANUP_DELAY = 5 * 60 * 1000;
    private final int ISS_ID = 25544;
    private final int MAX_TABLE_SIZE = 10;
    @Autowired
    IssRepository issRepository;
    @Autowired
    IssWebClientInterface issWebClient;

    @Override
    @Scheduled(fixedDelay = TABLE_CLEANUP_DELAY)
    public void refreshStoredLocation() {
        SatelliteLocation satelliteLocation = issWebClient.satelliteById(ISS_ID).block();
        issRepository.save(satelliteLocation);
        log.info("New isslocator location saved at :"+ LocalDateTime.now());
        while(issRepository.findAll().size()>MAX_TABLE_SIZE){
            issRepository.delete(issRepository.findAll().get(0));
            log.info("Reached max storage of locations ("+MAX_TABLE_SIZE+") Deleting oldest isslocator location");
        }
    }

    @Override
    public List<SatelliteLocation> getAllSatelliteLocations(){
        return issRepository.findAll();
    }
}
