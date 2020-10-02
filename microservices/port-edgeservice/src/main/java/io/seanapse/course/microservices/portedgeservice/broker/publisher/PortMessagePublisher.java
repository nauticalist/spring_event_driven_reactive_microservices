package io.seanapse.course.microservices.portedgeservice.broker.publisher;

import io.seanapse.course.sharedkernel.port.message.CreatePortMessage;
import reactor.core.publisher.Mono;

public interface PortMessagePublisher {
    void publishCreatePortMessage(CreatePortMessage message);
}
