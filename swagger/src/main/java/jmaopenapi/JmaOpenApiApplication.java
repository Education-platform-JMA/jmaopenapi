package jmaopenapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class JmaOpenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmaOpenApiApplication.class, args);
	}

}
