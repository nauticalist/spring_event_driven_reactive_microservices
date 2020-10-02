package io.seanapse.course.microservices.portedgeservice.api.client;

import io.seanapse.course.sharedkernel.port.dto.PortResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PortServiceClient {
    Flux<PortResponseDTO> getAllPorts();
    Mono<PortResponseDTO> getPortByPortId(String portId);
}
