package org.acme;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.acme.model.TemperatureSensor;
import org.acme.service.DataGenerator;
import org.acme.service.IDataProducer;
import org.acme.service.SimulatorService;
// import org.acme.service.SimulatorServiceRest;
// import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import io.vertx.core.json.Json;

@RequestScoped
public class SensorSimulator {
    // @Inject
    // @RestClient
    // SimulatorServiceRest simulatorServiceRest;
    @Inject
    SimulatorService simulatorService;
    @Inject
    DataGenerator dataGenerator;
    @Inject
    IDataProducer dataProducerAMQ;

    @Scheduled(every = "5s")
    public void generateSensorData() {
        List<TemperatureSensor> temperatureSamples = dataGenerator.temperatureSampler();
        for (TemperatureSensor sensorData : temperatureSamples) {
            simulatorService.showData(sensorData);
            Log.info("Received sensor data from device");
            dataProducerAMQ.sendData(sensorData);
            Log.info(Json.encode(sensorData));
            // simulatorServiceRest.callServiceController(sensorData);
        }
    }


}
