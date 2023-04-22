package org.acme.service;

import javax.enterprise.context.ApplicationScoped;

import io.vertx.core.json.Json;

@ApplicationScoped
public class SimulatorService {

    public void showData(Object sensorData) {
        System.out.println(Json.encode(sensorData));
    }
}
