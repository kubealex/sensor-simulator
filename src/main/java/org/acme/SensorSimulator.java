package org.acme;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.acme.model.SensorData;
import org.acme.service.DataGenerator;
import org.acme.service.SimulatorService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;

@RequestScoped
public class SensorSimulator {
    @Inject
    @RestClient
    SimulatorService simulatorService;
    @Inject
    DataGenerator dataGenerator;

    @Scheduled(every = "1s")
    public void generateSensorData() {
        List<SensorData> sensorList = dataGenerator.generateMeasurement();
        for (SensorData sensorData : sensorList) {
            simulatorService.callServiceController(sensorData);
        }
    }
}
