package org.acme;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.acme.model.TemperatureSensor;
import org.acme.service.DataGenerator;
import org.acme.service.SimulatorService;
// import org.acme.service.SimulatorServiceRest;
// import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;

@RequestScoped
public class SensorSimulator {
    // @Inject
    // @RestClient
    // SimulatorServiceRest simulatorServiceRest;
    @Inject
    SimulatorService simulatorService;
    @Inject
    DataGenerator dataGenerator;

    @Scheduled(every = "1s")
    public void generateSensorData() {
        List<TemperatureSensor> sensorList = dataGenerator.generateMeasurement();
        for (TemperatureSensor sensorData : sensorList) {
            simulatorService.showData(sensorData);
            // simulatorServiceRest.callServiceController(sensorData);
        }
    }
}
