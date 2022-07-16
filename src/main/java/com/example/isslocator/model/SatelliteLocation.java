package com.example.isslocator.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "satelliteLocations")
@NoArgsConstructor
public class SatelliteLocation {
    @Id @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name = "satelliteId")
    private long satelliteId;
    @Column(name = "name")
    private String name;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "altitude")
    private Double altitude;
    @Column(name = "velocity")
    private Double velocity;
    @Column(name = "visibility")
    private String visibility;
    @Column(name = "footprint")
    private Double footprint;
    @Column(name = "timestamp")
    private long timestamp;
    @Column(name = "daynum")
    private Double daynum;
    @Column(name = "solar_lat")
    private Double solarLat;
    @Column(name = "solar_lon")
    private Double solarLon;

    @Column(name = "units")
    private String units;

    public SatelliteLocation(long satelliteId, String name, Double latitude, Double longitude, Double altitude, Double velocity, String visibility, Double footprint, long timestamp, Double daynum, Double solarLat, Double solarLon, String units) {
        this.satelliteId = satelliteId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.velocity = velocity;
        this.visibility = visibility;
        this.footprint = footprint;
        this.timestamp = timestamp;
        this.daynum = daynum;
        this.solarLat = solarLat;
        this.solarLon = solarLon;
        this.units = units;
    }

    public SatelliteLocation(long satelliteId, String name){
        this.satelliteId = satelliteId;
        this.name = name;
    }

    public long getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(long satelliteId) {
        this.satelliteId = satelliteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getVelocity() {
        return velocity;
    }

    public void setVelocity(Double velocity) {
        this.velocity = velocity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Double getFootprint() {
        return footprint;
    }

    public void setFootprint(Double footprint) {
        this.footprint = footprint;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getDaynum() {
        return daynum;
    }

    public void setDaynum(Double daynum) {
        this.daynum = daynum;
    }

    public Double getSolarLat() {
        return solarLat;
    }

    public void setSolarLat(Double solarLat) {
        this.solarLat = solarLat;
    }

    public Double getSolarLon() {
        return solarLon;
    }

    public void setSolarLon(Double solarLon) {
        this.solarLon = solarLon;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
