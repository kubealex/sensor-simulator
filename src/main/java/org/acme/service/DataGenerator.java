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
                .setHumidity(generateRandomNumber(sensor.humidity().orElse(-500)))
                .setTemperature(generateRandomNumber(sensor.temperature().orElse(-500)))
                .setFixedTemperature(sensor.fixedTemperature().orElse(0))
                .setEcoMode(sensor.ecoMode().orElse(false))
                .setFanSpeed(sensor.fanSpeed().orElse(0))
                .setPowerConsumption(sensor.powerConsumption().orElse(0))
                .build();
    }

    private Double generateRandomNumber(Integer number) {
        if (number == -500)
            return 0.0;
        return ((Math.random() * ((number + 1) - (number - 1))) + (number - 1));
    }
}