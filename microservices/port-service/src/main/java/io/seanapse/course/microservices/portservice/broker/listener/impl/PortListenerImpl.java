package io.seanapse.course.microservices.portservice.broker.listener.impl;

import io.seanapse.course.microservices.portservice.broker.MessageSources;
import io.seanapse.course.microservices.portservice.broker.listener.PortListener;
import io.seanapse.course.microservices.portservice.broker.mapper.PortEventMapper;
import io.seanapse.course.microservices.portservice.domain.entity.Port;
import io.seanapse.course.microservices.portservice.service.command.PortCommandService;
import io.seanapse.course.sharedkernel.event.Event;
import io.seanapse.course.sharedkernel.port.message.CreatePortMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MessageSources.class)
public class PortListenerImpl implements PortListener {
    private final Logger LOG = LoggerFactory.getLogger(PortListenerImpl.class);

    private final PortCommandService portCommandService;
    private final PortEventMapper portEventMapper;

    @Autowired
    public PortListenerImpl(PortCommandService portCommandService, PortEventMapper portEventMapper) {
        this.portCommandService = portCommandService;
        this.portEventMapper = portEventMapper;
    }


    @Override
    @StreamListener(MessageSources.INPUT_PORTS_CREATE)
    public void onCreatePortMessageReceived(Event<String, CreatePortMessage> createPortMessageEvent) {
        LOG.info("[PORT-SERVICE] [BROKER] Create port message received: {}", createPortMessageEvent.toString());
        CreatePortMessage portMessage = createPortMessageEvent.getData();
        Port port = portEventMapper.mapCreatePortMessageToPort(portMessage);
        LOG.info("[PORT-SERVICE] [BROKER] Create port message mapped to Port entity: {}", port.toString());
        portCommandService.handleCreatePortCommand(port);
    }
}
