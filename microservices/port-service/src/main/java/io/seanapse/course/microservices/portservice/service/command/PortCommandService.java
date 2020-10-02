package io.seanapse.course.microservices.portservice.service.command;

import io.seanapse.course.microservices.portservice.domain.entity.Port;

public interface PortCommandService {
    void handleCreatePortCommand(Port port);
}
