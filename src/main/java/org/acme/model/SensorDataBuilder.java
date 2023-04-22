package org.acme.model;

public class SensorDataBuilder {

    String location = "" ;
    Double humidity = 0.0;
    Double temperature = 0.0;
    String deviceId = "";

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
    public SensorData build() {
        return new SensorData(location, humidity, temperature, deviceId);
    }
}
