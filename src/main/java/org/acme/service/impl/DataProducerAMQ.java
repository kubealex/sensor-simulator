package org.acme.service.impl;

import javax.inject.Inject;

import org.acme.model.SensorData;
import org.acme.service.IDataProducer;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import io.smallrye.reactive.messaging.annotations.Broadcast;

public class DataProducerAMQ implements IDataProducer {

    private Counter sampleCounter;
    private final MeterRegistry sentSamples;
    @Broadcast
    @Inject
    @Channel("sensor-data-out")
    Emitter<Object> sensorDataEmitter;

    DataProducerAMQ(MeterRegistry sentSamples) {
        this.sentSamples = sentSamples;
        sampleCounter = this.sentSamples.counter("amq.samples.sent");
    }

    public void sendData(Object data) {
        sampleCounter.increment();
        sensorDataEmitter.send(data);
    }
}
