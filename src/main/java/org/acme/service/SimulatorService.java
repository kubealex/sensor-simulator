package org.acme.service;

import javax.enterprise.context.ApplicationScoped;

import org.acme.model.TemperatureSensor;

import io.vertx.core.json.Json;

@ApplicationScoped
public class SimulatorService {

    public void showData(TemperatureSensor sensorData) {
        System.out.println(Json.encode(sensorData));
    }
}
