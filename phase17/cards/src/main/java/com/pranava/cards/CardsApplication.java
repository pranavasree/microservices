package com.pranava.cards;

import com.pranava.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
/*@ComponentScans({ @ComponentScan("com.pranava.loans.controller") })
@EnableJpaRepositories("com.pranava.loans.repository")
@EntityScan("com.pranava.loans.model")*/
@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Cards Microservice REST API Documentation",
				description = "Bank Cards Microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Pranava Reddy",
						email = "pranavareddy27@gmail.com",
						url = "pranavasree.me"

				),
				license = @License(
						name = "Apache2.0",
						url = "pranavasree.me"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Bank Cards Microservice REST API Documentation",
				url = "http://localhost:9002/swagger-ui/index.html"
		)

)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
