package com.exemple.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    // E.4 : routes statiques en Java, desactivees pour l'etape E.5 (routes dynamiques)
    // @Bean
    RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("route-calcul",
                        r -> r.path("/calcul/**")
                                .uri("lb://CALCUL-SERVICE"))
                .route("route-historique",
                        r -> r.path("/operations/**")
                                .uri("lb://HISTORIQUE-SERVICE"))
                .route("doc-calcul",
                        r -> r.path("/docs/calcul")
                                .filters(f -> f.setPath("/v3/api-docs"))
                                .uri("lb://CALCUL-SERVICE"))
                .route("doc-historique",
                        r -> r.path("/docs/historique")
                                .filters(f -> f.setPath("/v3/api-docs"))
                                .uri("lb://HISTORIQUE-SERVICE"))
                .build();
    }
}