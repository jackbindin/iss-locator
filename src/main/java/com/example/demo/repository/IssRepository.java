package com.example.demo.repository;

import com.example.demo.model.SatelliteLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssRepository extends JpaRepository<SatelliteLocation, Long> {

}
