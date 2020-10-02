package io.seanapse.course.microservices.portedgeservice.api.server;

import io.seanapse.course.microservices.portedgeservice.api.dto.CreatePortRequest;
import io.seanapse.course.sharedkernel.port.dto.PortResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequestMapping(value = "/api/ports")
public interface PortsController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Flux<PortResponseDTO> getAllPorts();

    @GetMapping(value = "/{portId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<PortResponseDTO>> getPortByPortId(@PathVariable String portId);


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<PortResponseDTO>> createPort(@Valid @RequestBody CreatePortRequest createPortRequest);
}
