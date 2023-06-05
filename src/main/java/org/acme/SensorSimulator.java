package org.acme;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import org.acme.model.SensorData;
import org.acme.service.DataGenerator;
import org.acme.service.DataSenderMQTT;
import org.acme.service.SimulatorService;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import io.vertx.core.json.Json;

@RequestScoped
public class SensorSimulator {
    @Inject
    SimulatorService simulatorService;
    @Inject
    DataGenerator dataGenerator;
    @Inject
    DataSenderMQTT dataSenderMQTT;

    @Scheduled(every = "5s")
    public void generateData() {
        SensorData sensorData = dataGenerator.generateSample();
        simulatorService.showData(sensorData);
        Log.info("Received sensor data from device");
        dataSenderMQTT.sendData(sensorData);
        Log.info(Json.encode(sensorData));
    }
}

