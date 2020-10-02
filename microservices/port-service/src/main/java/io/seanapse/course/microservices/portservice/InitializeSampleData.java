package io.seanapse.course.microservices.portservice;

import io.seanapse.course.microservices.portservice.domain.entity.Port;
import io.seanapse.course.microservices.portservice.domain.repository.PortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class InitializeSampleData implements ApplicationRunner {
    private final PortRepository portRepository;

    @Autowired
    public InitializeSampleData(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        portRepository.deleteAll()
                .thenMany(Flux.just(
                        new Port("0abd959c-b802-4324-9461-9d91d86c7851",
                                "Izmir", "Turkey", "TRIZM",  38.45704, 27.15267),
                        new Port("8ac83d63-97db-4c07-9854-b5da1217aa5b",
                                "Porto", "Portugal", "PTOPO", 41.14407, -8.6414315),
                        new Port("96901e45-ea02-451d-acfe-3f6dc77d42be",
                                "Tallinn", "Estonia", "EEVEB", 59.46138, 24.655385),
                        new Port("ba20ac16-21e8-4346-aeab-37c6430fbb59",
                                "Glasgow", "United Kingdom", "GBGLW", 55.869905, -4.336425),
                        new Port("effe0f4b-d686-442f-ab49-46e3f1546db8",
                                "Valencia", "Spain", "ESVLC",  39.44231, -0.31646595)))
                .flatMap(portRepository::save)
                .then()
                .doOnEach(System.out::println)
                .block();
    }
}
