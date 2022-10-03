package org.acme.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.SensorData;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class DataGenerator {
    @ConfigProperty(name = "sensor.locations")
    private String[] locations;
    @ConfigProperty(name = "sensor.devices")
    private String[] deviceId;

    public List<SensorData> generateMeasurement() {
        List<SensorData> sensorList = new ArrayList<>();
        for (int index = 0; index < deviceId.length; index++) {
            sensorList.add(new SensorData(locations[(int) (Math.random() * locations.length)],
                    this.generateRandomNumber(25, 30), deviceId[index]));
        }
        return sensorList;
        // return new SensorData(locations[(int) (Math.random()*locations.length)],
        // this.generateRandomNumber(15, 30), deviceId[(int)
        // (Math.random()*deviceId.length)]);
    }

    private Double generateRandomNumber(int min, int max) {
        return ((Math.random() * (max - min)) + min);
    }
}
