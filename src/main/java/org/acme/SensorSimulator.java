package org.acme;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.acme.model.SensorData;
import org.acme.service.DataGenerator;
import org.acme.service.DataSenderAMQ;
import org.acme.service.SimulatorService;
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
    DataSenderAMQ dataSenderAMQ;

    SensorData sensorData = new SensorData(null, null, null, null);
    @Scheduled(every = "5s")
    public void generateData() {
        sensorData = dataGenerator.generateSample();
        simulatorService.showData(sensorData);
        Log.info("Received sensor data from device");
        dataSenderAMQ.sendData(sensorData);
        Log.info(Json.encode(sensorData));
        }
    }

    // @Scheduled(every = "5s")
    // public void generateHumidityData() {
    //     List<HumiditySample> humiditySamples = dataGenerator.humiditySampler();
    //     for (HumiditySample humidityData : humiditySamples) {
    //         simulatorService.showData(humidityData);
    //         Log.info("Received sensor data from device");
    //         dataSenderAMQ.sendData(humidityData);
    //         Log.info(Json.encode(humidityData));
    //         // simulatorServiceRest.callServiceController(temperatureData);
    //     }
    // }

