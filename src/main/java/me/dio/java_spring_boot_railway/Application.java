package me.dio.java_spring_boot_railway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import java.util.Map;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Car Rental API")
						.version("1.0")
						.description("API Documentation for Car Rental Application"));
	}

	@PostConstruct
	public void printEnvironmentVariables() {
		System.out.println("\n==== ENVIRONMENT VARIABLES ====");

		Map<String, String> env = System.getenv();

		String[] keys = {
				"SPRING_PROFILES_ACTIVE",
				"PGDATABASE",
				"PGHOST",
				"PGPASSWORD",
				"PGPORT",
				"PGURLDATABASE",
				"PGUSER",
				"PORT"
		};

		for (String key : keys) {
			System.out.println(key + " = " + env.getOrDefault(key, "NOT SET"));
		}

		System.out.println("================================\n");
	}

}
