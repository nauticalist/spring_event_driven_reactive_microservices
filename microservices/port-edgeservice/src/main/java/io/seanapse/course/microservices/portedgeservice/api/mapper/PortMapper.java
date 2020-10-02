package io.seanapse.course.microservices.portedgeservice.api.mapper;

import io.seanapse.course.microservices.portedgeservice.api.dto.CreatePortRequest;
import io.seanapse.course.sharedkernel.port.dto.PortResponseDTO;
import io.seanapse.course.sharedkernel.port.message.CreatePortMessage;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PortMapper {
    @Mappings({
            @Mapping(target = "portId", ignore = true),
    })
    CreatePortMessage mapCreatePortRequestToCreatePortMessage(CreatePortRequest createPortRequest);

    @Mappings({
            @Mapping(target = "location", ignore = true)
    })
    PortResponseDTO mapCreatePortMessageToPortResponseDTO(CreatePortMessage message);

    @AfterMapping
    default void transformLatLongToLocation(CreatePortMessage message, @MappingTarget PortResponseDTO port) {
        double[] coordinates = new double[] { message.getLatitude(), message.getLongitude() };
        port.setLocation(coordinates);
    }
}
