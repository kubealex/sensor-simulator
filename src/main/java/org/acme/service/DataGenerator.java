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
        .setHumidity(generateRandomNumber(sensor.minHum().orElse(0), sensor.maxHum().orElse(0), sensor.temperature().orElse(0.0)))
        .setTemperature(generateRandomNumber(sensor.minTemp().orElse(0), sensor.maxTemp().orElse(0), sensor.temperature().orElse(0.0)))
        .setEcoMode(sensor.ecoMode().orElse(false))
        .setFanSpeed(sensor.fanSpeed().orElse(0))
        .build();
    }
    private Double generateRandomNumber(Integer min, Integer max, Double temperature) {
        if (temperature != 0.0)
            return temperature;
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