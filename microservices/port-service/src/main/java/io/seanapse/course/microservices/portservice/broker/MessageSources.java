package io.seanapse.course.microservices.portservice.broker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface MessageSources {
    String INPUT_PORTS_CREATE = "input-ports-create";
    String OUTPUT_PORTS_CREATED = "output-ports-created";

    String INPUT_PORTS_DELETE = "input-ports-delete";
    String OUTPUT_PORTS_DELETED= "output-ports-deleted";

    String INPUT_PORTS_UPDATE = "input-ports-update";
    String OUTPUT_PORTS_UPDATED= "output-ports-updated";

    @Input(INPUT_PORTS_CREATE)
    SubscribableChannel inputPortsCreate();

    @Output(OUTPUT_PORTS_CREATED)
    MessageChannel outputPortsCreated();

    @Input(INPUT_PORTS_DELETE)
    SubscribableChannel inputPortsDelete();

    @Output(OUTPUT_PORTS_DELETED)
    MessageChannel outputPortsDeleted();

    @Input(INPUT_PORTS_UPDATE)
    SubscribableChannel inputPortsUpdate();

    @Output(OUTPUT_PORTS_UPDATED)
    MessageChannel outputPortsUpdated();
}
