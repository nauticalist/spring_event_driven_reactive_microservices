package io.seanapse.course.microservices.portservice.api.server.impl;

import io.seanapse.course.microservices.portservice.api.mapper.PortResponseMapper;
import io.seanapse.course.microservices.portservice.api.server.PortController;
import io.seanapse.course.microservices.portservice.service.query.PortQueryService;
import io.seanapse.course.sharedkernel.port.dto.PortResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class PortControllerImpl implements PortController {
    private static final Logger LOG = LoggerFactory.getLogger(PortControllerImpl.class);

    private final PortQueryService portQueryService;
    private final PortResponseMapper portResponseMapper;

    @Autowired
    public PortControllerImpl(PortQueryService portQueryService, PortResponseMapper portResponseMapper) {
        this.portQueryService = portQueryService;
        this.portResponseMapper = portResponseMapper;
    }

    @Override
    public Mono<ResponseEntity<List<PortResponseDTO>>> getAllPorts() {
        LOG.info("[PORT-SERVICE] [GET] Get all ports request");
        return portQueryService.retrieveAllPorts()
                .map(portResponseMapper::mapPortToPortResponseDTO)
                .collectList()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build())
                .doOnError(ex -> LOG.warn("[PORT-SERVICE] [GET] Get all ports request failed" + ex.toString()))
                .log();
    }

    @Override
    public Mono<ResponseEntity<PortResponseDTO>> getPort(String portId) {
        LOG.info("[PORT-SERVICE] [GET] Get port by Id" + portId);
        return portQueryService.retrievePortById(portId)
                .map(portResponseMapper::mapPortToPortResponseDTO)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .doOnError(ex -> LOG.warn("[PORT-SERVICE] [GET] Get port by ID failed" + portId + ". Error: " + ex.toString()))
                .log();
    }
}
