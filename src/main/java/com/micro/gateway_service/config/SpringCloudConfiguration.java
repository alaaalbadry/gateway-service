package com.micro.gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringCloudConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("demo-order", r -> r.path("/orders/**")
                        .uri("lb://DEMO-ORDER")
                )

                .route("demo-payments", r -> r.path("/payments/**")
                        .uri("lb://DEMO-PAYMENT")
                )
                .route("user-service", r -> r.path("/users/**")
                        .uri("lb://USER-SERVICE")
                )
                .build();
    }

}