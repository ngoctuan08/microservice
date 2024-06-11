package com.ngoctuan.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("invoice-service", r -> r.path("/api/v1/invoice/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8084"))

                .route("auth-service", r -> r.path("/api/v1/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:9004"))

                .route("order-service", r -> r.path("/api/v1/order/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8086"))

                .route("shipping-service", r -> r.path("api/v1/shipment/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8082"))

                .route("employee-service", r -> r.path("api/v1/employee/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8088"))
                .build();
    }

}
