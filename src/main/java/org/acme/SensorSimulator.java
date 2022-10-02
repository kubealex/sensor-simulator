package org.acme;

import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.acme.model.SensorData;
import org.acme.service.ISimulatorService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
@RequestScoped
@Path("/")
public class SensorSimulator {
    @Inject
    @RestClient
    ISimulatorService iSimulatorService;

    @GET
    @Path("test")
    public void generateSensorData() {
        SensorData sensorData = new SensorData("bari", 0.1 , "foxtrot");
        iSimulatorService.callServiceController(sensorData);
    }
}
