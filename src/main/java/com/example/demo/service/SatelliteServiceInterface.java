package com.example.demo.service;

import com.example.demo.model.SatelliteLocation;

import java.util.List;

public interface SatelliteServiceInterface {
    void refreshStoredLocation();
    List<SatelliteLocation> getAllSatelliteLocations();
}
