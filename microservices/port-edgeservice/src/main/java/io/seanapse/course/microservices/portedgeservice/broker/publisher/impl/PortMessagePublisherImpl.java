package io.seanapse.course.microservices.portedgeservice.broker.publisher.impl;

import io.seanapse.course.microservices.portedgeservice.broker.MessageSources;
import io.seanapse.course.microservices.portedgeservice.broker.publisher.PortMessagePublisher;
import io.seanapse.course.sharedkernel.event.Event;
import io.seanapse.course.sharedkernel.port.message.CreatePortMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MessageSources.class)
public class PortMessagePublisherImpl implements PortMessagePublisher {
    private final Logger LOG = LoggerFactory.getLogger(PortMessagePublisherImpl.class);

    private final MessageSources sources;

    public PortMessagePublisherImpl(MessageSources sources) {
        this.sources = sources;
    }

    @Override
    public void publishCreatePortMessage(CreatePortMessage message) {
        sources.outputPortsCreate()
                .send(MessageBuilder.withPayload(new Event(message.getPortId(), message)).build());
    }
}
