package com.example.isslocator.service;

import com.example.isslocator.model.SatelliteLocation;

import java.util.List;

public interface SatelliteServiceInterface {
    void refreshStoredLocation();
    List<SatelliteLocation> getAllSatelliteLocations();
}
