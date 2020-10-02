package io.seanapse.course.microservices.portservice.service.query.impl;

import io.seanapse.course.microservices.portservice.domain.entity.Port;
import io.seanapse.course.microservices.portservice.domain.repository.PortRepository;
import io.seanapse.course.microservices.portservice.service.query.PortQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PortQueryServiceImpl implements PortQueryService {
    private final PortRepository portRepository;

    @Autowired
    public PortQueryServiceImpl(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    public Flux<Port> retrieveAllPorts() {
        return portRepository.findAll();
    }

    @Override
    public Mono<Port> retrievePortById(String portId) {
        return portRepository.findByPortId(portId);
    }
}
