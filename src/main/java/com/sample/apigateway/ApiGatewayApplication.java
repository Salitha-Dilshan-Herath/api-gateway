package com.sample.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class ApiGatewayApplication {

	private final GetRequestFilter getRequestFilter = new GetRequestFilter();

	private final ResponseValidationFilter responseValidationFilter = new ResponseValidationFilter();

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayLocator(RouteLocatorBuilder builder){

		return builder.routes()
				.route( p -> p
						.path("/get")
						.and()
						.method(HttpMethod.GET)
						.filters(f -> f.filter(getRequestFilter).filters(responseValidationFilter))
						.uri("https://httpbin.org/get"))
				.build();
	}
}
