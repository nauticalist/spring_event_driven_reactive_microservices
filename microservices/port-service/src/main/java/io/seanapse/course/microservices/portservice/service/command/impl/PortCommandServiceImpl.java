package io.seanapse.course.microservices.portservice.service.command.impl;

import io.seanapse.course.microservices.portservice.broker.publisher.PortPublisher;
import io.seanapse.course.microservices.portservice.domain.entity.Port;
import io.seanapse.course.microservices.portservice.domain.repository.PortRepository;
import io.seanapse.course.microservices.portservice.service.command.PortCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortCommandServiceImpl implements PortCommandService {
    private final PortRepository portRepository;
    private final PortPublisher portPublisher;

    @Autowired
    public PortCommandServiceImpl(PortRepository portRepository, PortPublisher portPublisher) {
        this.portRepository = portRepository;
        this.portPublisher = portPublisher;
    }

    @Override
    public void handleCreatePortCommand(Port port) {
        Port portCreated = portRepository.save(port).block();
        portPublisher.onPortCreatedEvent(portCreated);
    }
}
