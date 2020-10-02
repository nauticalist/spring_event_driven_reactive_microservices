package io.seanapse.course.microservices.portservice.broker.publisher.impl;

import io.seanapse.course.microservices.portservice.broker.MessageSources;
import io.seanapse.course.microservices.portservice.broker.mapper.PortEventMapper;
import io.seanapse.course.microservices.portservice.broker.publisher.PortPublisher;
import io.seanapse.course.microservices.portservice.domain.entity.Port;
import io.seanapse.course.sharedkernel.event.Event;
import io.seanapse.course.sharedkernel.port.event.PortCreatedEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MessageSources.class)
public class PortPublisherImpl implements PortPublisher {
    private final MessageSources sources;

    private final PortEventMapper portEventMapper;

    public PortPublisherImpl(MessageSources sources, PortEventMapper portEventMapper) {
        this.sources = sources;
        this.portEventMapper = portEventMapper;
    }

    @Override
    public void onPortCreatedEvent(Port port) {
        PortCreatedEvent portCreatedEvent = portEventMapper.mapPortToPortCreatedEvent(port);
        sources.outputPortsCreated()
                .send(MessageBuilder.withPayload(new Event(portCreatedEvent.getPortId(), portCreatedEvent)).build());
    }
}
