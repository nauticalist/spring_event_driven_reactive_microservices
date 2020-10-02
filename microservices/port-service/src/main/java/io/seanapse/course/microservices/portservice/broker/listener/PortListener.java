package io.seanapse.course.microservices.portservice.broker.listener;

import io.seanapse.course.sharedkernel.event.Event;
import io.seanapse.course.sharedkernel.port.message.CreatePortMessage;

public interface PortListener {
    void onCreatePortMessageReceived(Event<String, CreatePortMessage> createPortMessageEvent);
}
