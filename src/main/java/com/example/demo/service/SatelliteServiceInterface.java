package com.example.demo.service;

import com.example.demo.model.SatelliteLocation;

import java.util.List;

public interface SatelliteServiceInterface {
    SatelliteLocation getSatelliteById(int id);
    List<SatelliteLocation> getAllSatelliteLocations();
}
