package org.acme.model;

import java.util.Optional;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "sensor")
public interface Sensor {
    String deviceId();
    String location();
    Optional<Integer> humidity();
    Optional<Boolean> ecoMode();
    Optional<Integer> fanSpeed();
    Optional<Integer> fixedTemperature();
    Optional<Integer> powerConsumption();
}
