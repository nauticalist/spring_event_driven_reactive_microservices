package io.seanapse.course.microservices.portedgeservice.api.server.impl;

import io.seanapse.course.microservices.portedgeservice.api.client.PortServiceClient;
import io.seanapse.course.microservices.portedgeservice.api.dto.CreatePortRequest;
import io.seanapse.course.microservices.portedgeservice.api.mapper.PortMapper;
import io.seanapse.course.microservices.portedgeservice.api.server.PortsController;
import io.seanapse.course.microservices.portedgeservice.service.command.PortCommandService;
import io.seanapse.course.sharedkernel.port.dto.PortResponseDTO;
import io.seanapse.course.sharedkernel.port.message.CreatePortMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class PortsControllerImpl implements PortsController {
    private static final Logger LOG = LoggerFactory.getLogger(PortsControllerImpl.class);

    private final PortServiceClient portServiceClient;
    private final PortMapper portMapper;
    private final PortCommandService portCommandService;

    @Autowired
    public PortsControllerImpl(PortServiceClient portServiceClient, PortMapper portMapper, PortCommandService portCommandService) {
        this.portServiceClient = portServiceClient;
        this.portMapper = portMapper;
        this.portCommandService = portCommandService;
    }

    @Override
    public Flux<PortResponseDTO> getAllPorts() {
        return portServiceClient.getAllPorts()
                .doOnError(ex -> LOG.warn("[PORT-EDGESERVICE] [GET] getPorts failed: {}", ex.toString()))
                .log();
    }

    @Override
    public Mono<ResponseEntity<PortResponseDTO>> getPortByPortId(String portId) {
        return portServiceClient.getPortByPortId(portId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .doOnError(ex -> LOG.warn("[PORT-EDGESERVICE] [GET] get port with port id failed: {}", ex.toString()))
                .log();
    }

    @Override
    public Mono<ResponseEntity<PortResponseDTO>> createPort(@Valid CreatePortRequest createPortRequest) {
        try {
            LOG.info("[PORT-EDGESERVICE] [POST] Create port command executed on controller: {}", createPortRequest.toString());
            CreatePortMessage message = portMapper.mapCreatePortRequestToCreatePortMessage(createPortRequest);

            return portCommandService.handleCreatePortCommand(message)
                    .map(portMapper::mapCreatePortMessageToPortResponseDTO)
                    .map(ResponseEntity::ok);
        } catch (RuntimeException re) {
            LOG.warn("Create port command failed to execute: {}", re.toString());
            throw re;
        }
    }
}
