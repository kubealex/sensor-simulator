package org.acme.service;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.SensorData;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class DataGenerator {
    @ConfigProperty(name = "sensor.locations")
    private String[] locations;
    @ConfigProperty(name = "sensor.devices")
    private String[] deviceId;
    public SensorData generateMeasurement() {
        return new SensorData(locations[(int) (Math.random()*locations.length)], Math.random()*10, deviceId[(int) (Math.random()*deviceId.length)]);
    }
}
