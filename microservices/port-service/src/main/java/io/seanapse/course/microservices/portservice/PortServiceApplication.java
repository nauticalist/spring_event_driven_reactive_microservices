package io.seanapse.course.microservices.portservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@ComponentScan("io.seanapse.course")
@EnableMongoAuditing
public class PortServiceApplication {

	private static final Logger LOG = LoggerFactory.getLogger(PortServiceApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(PortServiceApplication.class, args);
		String mongodDbName = ctx.getEnvironment().getProperty("spring.data.mongodb.database");
		LOG.info("Connected to MongoDb: " + mongodDbName);
	}

}
