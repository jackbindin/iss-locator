package com.example.demo.controller;

import com.example.demo.model.SatelliteLocation;
import com.example.demo.service.SatelliteService;
import com.example.demo.service.SatelliteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
public class SatelliteLocationController {
    @Autowired
    SatelliteServiceInterface satelliteService;

    @GetMapping("satellite/iss")
    public ResponseEntity<Void> getSatelliteById() throws SQLException {
        //https://www.google.com/maps/dir/Pontoppidans+gate+15B,+0462+Oslo/Bydel+Sagene,+Oslo/Torshov,+Oslo/Nationaltheatret,+Johanne+Dybwads+plass+1,+0161+Oslo/
        satelliteService.getSatelliteById(25544);
        String locationsString = "https://www.google.com/maps/dir/";
        List<SatelliteLocation> locations = satelliteService.getAllSatelliteLocations();
        for(SatelliteLocation satelliteLocation:satelliteService.getAllSatelliteLocations()){
            locationsString=locationsString + satelliteLocation.getLatitude() + "," + satelliteLocation.getLongitude() + "/";
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(locationsString)).build();
    }
}
