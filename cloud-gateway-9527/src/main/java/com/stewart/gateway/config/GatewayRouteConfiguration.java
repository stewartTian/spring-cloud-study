package com.stewart.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 以java代码bean的方式配置路由
 */
@Configuration
public class GatewayRouteConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_stewart",
                r -> r.path("/tech")
                        .uri("http://news.baidu.com/tech")).build();

        return routes.build();
    }

}
