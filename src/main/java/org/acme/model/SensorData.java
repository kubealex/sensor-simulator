package org.acme.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorData {
    @JsonProperty("sensor_location")
    protected String location;
    // @JsonProperty("sensor_data")
    // private Double temperature;
    @JsonProperty("sensor_id")
    protected String deviceID;
    @JsonProperty("sensor_timestamp")
    protected Instant timestamp;

    public SensorData(String location, String deviceID) {
 // public SensorData(String location, Double temperature, String deviceID) {
        this.location = location;
        this.deviceID = deviceID;
        this.timestamp = Instant.now();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // public Double getTemperature() {
    //     return temperature;
    // }

    // public void setTemperature(Double temperature) {
    //     this.temperature = temperature;
    // }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
}
