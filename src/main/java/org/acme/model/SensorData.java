package org.acme.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorData {
    @JsonProperty("sensor_location")
    protected String location;
    @JsonProperty("sensor_temperature_data")
    private Double temperature;
    @JsonProperty("sensor_humidity_data")
    protected Double humidity;
    @JsonProperty("sensor_id")
    protected String deviceID;
    @JsonProperty("sensor_eco_mode")
    protected Boolean ecoMode;
    @JsonProperty("sensor_fan_speed")
    protected Integer fanSpeed;
    @JsonProperty("sensor_fixed_temperature")
    protected Integer fixedTemperature;
    @JsonProperty("sensor_power_consumption")
    protected Integer powerConsumption;
    @JsonProperty("sensor_timestamp")
    protected Instant timestamp;

    public SensorData(String location, Double humidity, Double temperature, String deviceID, Boolean ecoMode, Integer fanSpeed, Integer fixedTemperature, Integer powerConsumption) {
        this.location = location;
        this.humidity = humidity;
        this.deviceID = deviceID;
        this.temperature = temperature;
        this.fanSpeed = fanSpeed;
        this.ecoMode = ecoMode;
        this.fixedTemperature = fixedTemperature;
        this.timestamp = Instant.now();
        this.powerConsumption = powerConsumption;
    }
}
