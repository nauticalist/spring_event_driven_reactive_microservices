package io.seanapse.course.microservices.portservice.service.query;

import io.seanapse.course.microservices.portservice.domain.entity.Port;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PortQueryService {
    Flux<Port> retrieveAllPorts();

    Mono<Port> retrievePortById(String portId);
}
