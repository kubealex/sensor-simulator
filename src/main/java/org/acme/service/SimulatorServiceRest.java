package org.acme.service;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.acme.model.SensorData;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/v1")
@RegisterRestClient
public interface SimulatorServiceRest {
    @POST
    @Path("/data")
    Response callServiceController(SensorData sensorData);
}
