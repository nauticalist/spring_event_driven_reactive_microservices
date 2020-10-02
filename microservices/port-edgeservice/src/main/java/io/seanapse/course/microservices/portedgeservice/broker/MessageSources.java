package io.seanapse.course.microservices.portedgeservice.broker;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface MessageSources {
    String OUTPUT_PORTS_CREATE = "output-ports-create";
    String OUTPUT_PORTS_UPDATE = "output-ports-update";
    String OUTPUT_PORTS_DELETE = "output-ports-delete";

    @Output(OUTPUT_PORTS_CREATE)
    MessageChannel outputPortsCreate();

    @Output(OUTPUT_PORTS_UPDATE)
    MessageChannel outputPortsUpdate();

    @Output(OUTPUT_PORTS_DELETE)
    MessageChannel outputPortsDelete();
}
