package org.lab.network.diagnostic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DiagnosticApp {

	public static void main(String[] args) {
		SpringApplication.run(DiagnosticApp.class, args);
	}

	@Bean
	public Docket docket() { //@formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
				.apis(RequestHandlerSelectors.basePackage("org.lab.network"))
				.paths(PathSelectors.any())
				.build();
	} //@formatter:on
}
