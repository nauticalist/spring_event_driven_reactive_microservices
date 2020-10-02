package io.seanapse.course.microservices.portservice.domain.repository;

import io.seanapse.course.microservices.portservice.domain.entity.Port;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@Repository
public interface PortRepository extends ReactiveMongoRepository<Port, String> {
    Mono<Port> findByPortId(String portId);

    @Query("{ id: { $exists: true }}")
    Flux<Port> retrieveAllPorts(final Pageable page);

    Flux<Port> findByPortNameContainsIgnoreCase(String portName, Pageable pageable);

    Flux<GeoResult<Port>> findByLocationNear(Point location);

    Flux<GeoResult<Port>> findByLocationNear(Point location, Distance distance);
}
