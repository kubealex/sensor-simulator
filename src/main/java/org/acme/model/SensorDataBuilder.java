package org.acme.model;

public class SensorDataBuilder {

    String location = "" ;
    Double humidity = 0.0;
    Double temperature = 0.0;
    String deviceId = "";
    Boolean ecoMode = false;
    Integer fanSpeed = 0;
    Integer fixedTemperature = 0;

    public SensorDataBuilder setLocation(String location) {
        this.location = location;
        return this;
    }
    public SensorDataBuilder setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }
    public SensorDataBuilder setTemperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }
    public SensorDataBuilder setHumidity(Double humidity) {
        this.humidity = humidity;
        return this;
    }
    public SensorDataBuilder setEcoMode(Boolean ecoMode) {
        this.ecoMode = ecoMode;
        return this;
    }
    public SensorDataBuilder setFanSpeed(Integer fanSpeed) {
        this.fanSpeed = fanSpeed;
        return this;
    }
    public SensorDataBuilder setFixedTemperature(Integer fixedTemperature) {
        this.fixedTemperature = fixedTemperature;
        return this;
    }
    public SensorData build() {
        return new SensorData(location, humidity, temperature, deviceId, ecoMode, fanSpeed, fixedTemperature);
    }
}
