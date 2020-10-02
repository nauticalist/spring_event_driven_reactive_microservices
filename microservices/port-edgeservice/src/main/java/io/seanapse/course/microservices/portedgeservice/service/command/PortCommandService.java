package io.seanapse.course.microservices.portedgeservice.service.command;

import io.seanapse.course.sharedkernel.port.message.CreatePortMessage;
import reactor.core.publisher.Mono;

public interface PortCommandService {
    Mono<CreatePortMessage> handleCreatePortCommand(CreatePortMessage portMessage);
}
