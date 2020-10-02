package io.seanapse.course.microservices.portservice.broker.mapper;

import io.seanapse.course.microservices.portservice.domain.entity.Port;
import io.seanapse.course.sharedkernel.port.event.PortCreatedEvent;
import io.seanapse.course.sharedkernel.port.message.CreatePortMessage;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PortEventMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "location", ignore = true)
    })
    Port mapCreatePortMessageToPort(CreatePortMessage createPortMessage);

    @AfterMapping
    default void transformLatLongToLocation(CreatePortMessage message, @MappingTarget Port port) {
        double[] coordinates = new double[] { message.getLatitude(), message.getLongitude() };
        port.setLocation(coordinates);
    }

    PortCreatedEvent mapPortToPortCreatedEvent(Port port);
}
