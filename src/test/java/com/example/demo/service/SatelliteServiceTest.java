package com.example.demo.service;

import com.example.demo.model.SatelliteLocation;
import com.example.demo.repository.IssRepository;
import com.example.demo.webclient.IssWebClientInterface;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SatelliteServiceTest {
    @InjectMocks
    SatelliteService satelliteService;
    @Mock
    IssRepository issRepository;
    @Mock
    IssWebClientInterface issWebClient;

    @Test
    public void testGetAllSatelliteLocations(){
        List<SatelliteLocation> satelliteLocations =  makeSatelliteLocationsList();
        when(issRepository.findAll()).thenReturn(satelliteLocations);
        assertEquals(satelliteLocations,satelliteService.getAllSatelliteLocations());
    }

    @Test
    public void testRefreshStoredLocationShouldNotRemoveAnyFromList(){
        List<SatelliteLocation> satelliteLocations =  makeSatelliteLocationsList();
        List<SatelliteLocation> satelliteLocations2 = new LinkedList<>();
        SatelliteLocation satelliteLocation = new SatelliteLocation(1,"satellite12");
        satelliteLocations2.add(satelliteLocation);
        when(issWebClient.satelliteById(anyInt())).thenReturn(Mono.just(satelliteLocation));
        when(issRepository.findAll()).thenReturn(satelliteLocations).thenReturn(satelliteLocations2);
        satelliteService.refreshStoredLocation();
        verify(issRepository, times(1)).delete(any());
    }

    private List<SatelliteLocation> makeSatelliteLocationsList(){
        List<SatelliteLocation> satelliteLocations = new LinkedList<>();
        satelliteLocations.add(new SatelliteLocation(1,"satellite1"));
        satelliteLocations.add(new SatelliteLocation(2,"satellite2"));
        satelliteLocations.add(new SatelliteLocation(3,"satellite3"));
        satelliteLocations.add(new SatelliteLocation(4,"satellite4"));
        satelliteLocations.add(new SatelliteLocation(5,"satellite5"));
        satelliteLocations.add(new SatelliteLocation(6,"satellite6"));
        satelliteLocations.add(new SatelliteLocation(7,"satellite7"));
        satelliteLocations.add(new SatelliteLocation(8,"satellite8"));
        satelliteLocations.add(new SatelliteLocation(9,"satellite9"));
        satelliteLocations.add(new SatelliteLocation(10,"satellite10"));
        satelliteLocations.add(new SatelliteLocation(11,"satellite11"));
        return satelliteLocations;
    }
}
