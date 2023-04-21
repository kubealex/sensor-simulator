package org.acme.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureSensor extends SensorData {
    @JsonProperty("sensor_temperature_data")
    private Double temperature;

    public TemperatureSensor(String location, Double temperature, String deviceID) {

        super(location, deviceID);
        this.temperature = temperature;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
