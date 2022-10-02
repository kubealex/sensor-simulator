package org.acme.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.acme.model.SensorData;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/v1")
@RegisterRestClient
public interface ISimulatorService {
    @POST
    @Path("/data")
    Response callServiceController(SensorData sensorData);
}
