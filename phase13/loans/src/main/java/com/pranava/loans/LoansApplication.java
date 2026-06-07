package com.pranava.loans;

import com.pranava.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
/*@ComponentScans({ @ComponentScan("com.pranava.loans.controller") })
@EnableJpaRepositories("com.pranava.loans.repository")
@EntityScan("com.pranava.loans.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Loans Microservice REST API Documentation",
				description = "Bank Loans Microservice REST API Documentation",
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
				description = "Bank Loans Microservice REST API Documentation",
				url = "http://localhost:9001/swagger-ui/index.html"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
