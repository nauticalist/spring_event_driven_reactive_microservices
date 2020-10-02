package io.seanapse.course.microservices.portedgeservice.service.command.impl;

import io.seanapse.course.microservices.portedgeservice.broker.publisher.PortMessagePublisher;
import io.seanapse.course.microservices.portedgeservice.service.command.PortCommandService;
import io.seanapse.course.sharedkernel.port.message.CreatePortMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class PortCommandServiceImpl implements PortCommandService {
    private final PortMessagePublisher portMessagePublisher;

    @Autowired
    public PortCommandServiceImpl(PortMessagePublisher portMessagePublisher) {
        this.portMessagePublisher = portMessagePublisher;
    }

    @Override
    public Mono<CreatePortMessage> handleCreatePortCommand(CreatePortMessage portMessage) {
        portMessage.setPortId(UUID.randomUUID().toString());
        portMessagePublisher.publishCreatePortMessage(portMessage);

        return Mono.just(portMessage);
    }
}
