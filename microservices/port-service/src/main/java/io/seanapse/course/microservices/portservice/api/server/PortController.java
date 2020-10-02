package io.seanapse.course.microservices.portservice.api.server;

import io.seanapse.course.microservices.portservice.domain.entity.Port;
import io.seanapse.course.sharedkernel.port.dto.PortResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("/api/ports")
public interface PortController {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<List<PortResponseDTO>>> getAllPorts();

    @GetMapping(value = "/{portId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<PortResponseDTO>> getPort(@PathVariable String portId);
}
