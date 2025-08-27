package uk.multicode.bam.apigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}

	@Value("${userServiceUrl}")
	private String userServiceUrl;

	@Value("${buildingServiceUrl}")
	private String buildingServiceUrl;

	@Value("${accessServiceUrl}")
	private String accessServiceUrl;


	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/api/user/**")
						.uri(userServiceUrl))
				.route(p -> p
						.path("/api/location")
						.uri(buildingServiceUrl))
				.route(p -> p
						.path("/api/location/**")
						.filters(f -> f.rewritePath("/api/location/(?<segment>.*)", "/api/location/${segment}"))
						.uri(buildingServiceUrl))
				.route(p -> p
						.path("/api/building")
						.uri(buildingServiceUrl))
				.route(p -> p
						.path("/api/building/**")
						.filters(f -> f.rewritePath("/api/building(?<segment>.*)", "/api/building/${segment}"))
						.uri(buildingServiceUrl))
				.route(p -> p
						.path("/api/accessgroup")
						.uri(accessServiceUrl))
				.route(p -> p
						.path("/api/accessgroup/**")
						.filters(f -> f.rewritePath("/api/accessgroup(?<segment>.*)", "/api/accessgroup/${segment}"))
						.uri(accessServiceUrl))
				.route(p -> p
						.path("/api/accessgroupuser/**")
						.filters(f -> f.rewritePath("/api/accessgroupuser/(?<segment>.*)", "/api/user/${segment}"))
						.uri(accessServiceUrl))
				.build();
	}
}
