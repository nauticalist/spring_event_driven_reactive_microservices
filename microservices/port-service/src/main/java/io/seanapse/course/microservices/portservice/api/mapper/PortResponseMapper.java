package io.seanapse.course.microservices.portservice.api.mapper;


import io.seanapse.course.microservices.portservice.domain.entity.Port;
import io.seanapse.course.sharedkernel.port.dto.PortResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PortResponseMapper {
    PortResponseDTO mapPortToPortResponseDTO(Port port);
}
