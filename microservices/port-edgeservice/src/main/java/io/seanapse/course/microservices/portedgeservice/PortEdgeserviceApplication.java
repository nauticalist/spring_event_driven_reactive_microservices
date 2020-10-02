package io.seanapse.course.microservices.portedgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("io.seanapse.course")
@SpringBootApplication
public class PortEdgeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortEdgeserviceApplication.class, args);
	}

}
