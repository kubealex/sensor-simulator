package org.acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.model.Sensor;
import org.acme.model.SensorData;
import org.acme.model.SensorDataBuilder;

@ApplicationScoped
public class DataGenerator {

    @Inject
     Sensor sensor;

    public SensorData generateSample() {
        return new SensorDataBuilder()
        .setDeviceId(sensor.deviceId())
        .setLocation(sensor.location())
        .setHumidity(generateRandomNumber(sensor.minHum(), sensor.maxHum()))
        .setTemperature(generateRandomNumber(sensor.minTemp(), sensor.maxTemp()))
        .build();
    }
    private Double generateRandomNumber(int min, int max) {
        return ((Math.random() * (max - min)) + min);
    }
    // @ConfigProperty(name = "sensor.locations")
    // private String[] locations;
    // @ConfigProperty(name = "sensor.devices")
    // private String[] deviceId;

    // public List<TemperatureSample> temperatureSampler() {
    //     List<TemperatureSample> temperatureSamples = new ArrayList<>();
    //     for (int locationIndex = 0; locationIndex < locations.length; locationIndex++) {
    //         for (int index = 0; index < deviceId.length; index++) {
    //             temperatureSamples.add(new TemperatureSample(locations[locationIndex],
    //                     this.generateRandomNumber(25, 30), deviceId[index]));
    //         }
    //     }
    //     return temperatureSamples;
    // }

    // public List<HumiditySample> humiditySampler() {
    //     List<HumiditySample> humiditySamples = new ArrayList<>();
    //     for (int locationIndex = 0; locationIndex < locations.length; locationIndex++) {
    //         for (int index = 0; index < deviceId.length; index++) {
    //             humiditySamples.add(new HumiditySample(locations[locationIndex],
    //                     this.generateRandomNumber(15, 75), deviceId[index]));
    //         }
    //     }
    //     return humiditySamples;
    // }
}