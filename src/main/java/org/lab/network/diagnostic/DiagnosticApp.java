package org.lab.network.diagnostic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DiagnosticApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DiagnosticApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DiagnosticApp.class);
	}

	@Bean
	public Docket docket() { // @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
				.apis(RequestHandlerSelectors.basePackage("org.lab.network.diagnostic.controller"))
				.paths(PathSelectors.any())
				.build();
	} // @formatter:on

	@Bean
	public UiConfiguration uiConfig() { // @formatter:off
		return UiConfigurationBuilder.builder()
			.validatorUrl(null)
	        .build();
	}// @formatter:on

}
