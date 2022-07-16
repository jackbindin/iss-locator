package com.example.isslocator.controller;

import com.example.isslocator.model.SatelliteLocation;
import com.example.isslocator.service.SatelliteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
public class SatelliteLocationController {
    @Autowired
    SatelliteServiceInterface satelliteService;

    @GetMapping("satellite/isslocator")
    public ResponseEntity<Void> getIssLocations() throws SQLException {
        String locationsString = "https://www.google.com/maps/dir/";
        List<SatelliteLocation> locations = satelliteService.getAllSatelliteLocations();
        for(SatelliteLocation satelliteLocation:satelliteService.getAllSatelliteLocations()){
            locationsString=locationsString + satelliteLocation.getLatitude() + "," + satelliteLocation.getLongitude() + "/";
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(locationsString)).build();
    }
}
