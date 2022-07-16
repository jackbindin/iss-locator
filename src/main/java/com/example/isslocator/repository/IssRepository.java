package com.example.isslocator.repository;

import com.example.isslocator.model.SatelliteLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssRepository extends JpaRepository<SatelliteLocation, Long> {

}
