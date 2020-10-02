package io.seanapse.course.microservices.portservice.broker.publisher;

import io.seanapse.course.microservices.portservice.domain.entity.Port;

public interface PortPublisher {
    void onPortCreatedEvent(Port port);
}
