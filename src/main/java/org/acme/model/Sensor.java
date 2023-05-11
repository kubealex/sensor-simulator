package org.acme.model;

import java.util.Optional;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "sensor")
public interface Sensor {
    String deviceId();
    String location();
    Optional<Integer> humidity();
    // Optional<Integer> minTemp();
    // Optional<Integer> maxTemp();
    // Optional<Integer> minHum();
    // Optional<Integer> maxHum();
    Optional<Boolean> ecoMode();
    Optional<Integer> fanSpeed();
    Optional<Integer> fixedTemperature();
    Optional<Integer> powerConsumption();
}
