package org.acme.model;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;

@StaticInitSafe
@ConfigMapping(prefix = "sensor")
public interface Sensor {
    String deviceId();
    String location();
    Integer minTemp();
    Integer maxTemp();
    Integer minHum();
    Integer maxHum();
}
