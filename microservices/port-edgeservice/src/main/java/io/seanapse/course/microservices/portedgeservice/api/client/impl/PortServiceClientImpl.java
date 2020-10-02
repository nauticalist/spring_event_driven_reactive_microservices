package io.seanapse.course.microservices.portedgeservice.api.client.impl;

import io.seanapse.course.microservices.portedgeservice.api.client.PortServiceClient;
import io.seanapse.course.sharedkernel.port.dto.PortResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PortServiceClientImpl implements PortServiceClient {
    private static final Logger LOG = LoggerFactory.getLogger(PortServiceClientImpl.class);

    private final WebClient webClient;

    @Autowired
    public PortServiceClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<PortResponseDTO> getAllPorts() {
        LOG.info("[PORT-EDGESERVICE] [WEBCLIENT] Get all ports request from port service");

        return webClient.get().uri("/api/ports")
                .retrieve().bodyToFlux(PortResponseDTO.class)
                .log()
                .onErrorResume(error -> Flux.empty());
    }

    @Override
    public Mono<PortResponseDTO> getPortByPortId(String portId) {
        LOG.info("[PORT-EDGESERVICE] [WEBCLIENT] Get port by id " + portId + " request from port service");
        return webClient.get().uri(
                uriBuilder -> uriBuilder.path("/api/ports/" + portId).build()
        ).retrieve().bodyToMono(PortResponseDTO.class)
                .log();
    }
}
